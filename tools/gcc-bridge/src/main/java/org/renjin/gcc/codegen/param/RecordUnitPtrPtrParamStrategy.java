package org.renjin.gcc.codegen.param;

import com.google.common.base.Optional;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.renjin.gcc.codegen.RecordClassGenerator;
import org.renjin.gcc.codegen.Var;
import org.renjin.gcc.codegen.VarAllocator;
import org.renjin.gcc.codegen.WrapperType;
import org.renjin.gcc.codegen.expr.AbstractExprGenerator;
import org.renjin.gcc.codegen.expr.ExprGenerator;
import org.renjin.gcc.codegen.pointers.DereferencedUnitRecordPtr;
import org.renjin.gcc.gimple.GimpleParameter;
import org.renjin.gcc.gimple.type.GimplePointerType;
import org.renjin.gcc.gimple.type.GimpleType;
import org.renjin.gcc.runtime.ObjectPtr;

import java.util.Collections;
import java.util.List;

/**
 * Strategy for a parameter that is a pointer to one or more unit record pointers, implemented using a single
 * {@link ObjectPtr} parameter. Each element of {@link ObjectPtr#array} is a reference to the record's JVM class.
 */
public class RecordUnitPtrPtrParamStrategy extends ParamStrategy {
  
  private RecordClassGenerator generator;

  public RecordUnitPtrPtrParamStrategy(RecordClassGenerator generator) {
    this.generator = generator;
  }

  @Override
  public List<Type> getParameterTypes() {
    return Collections.singletonList(Type.getType(ObjectPtr.class));
  }

  @Override
  public ExprGenerator emitInitialization(MethodVisitor methodVisitor, GimpleParameter parameter, List<Var> paramVars, VarAllocator localVars) {
    return new ParamExpr(paramVars.get(0));
  }

  @Override
  public void emitPushParameter(MethodVisitor mv, ExprGenerator parameterValueGenerator) {
    parameterValueGenerator.emitPushPointerWrapper(mv);
  }

  private class ParamExpr extends AbstractExprGenerator {

    private Var var;

    public ParamExpr(Var var) {
      this.var = var;
    }

    @Override
    public GimpleType getGimpleType() {
      return new GimplePointerType(new GimplePointerType(generator.getGimpleType()));
    }

    @Override
    public ExprGenerator valueOf() {
      return new DereferencedUnitRecordPtr(this);
    }

    @Override
    public void emitPushPtrArrayAndOffset(MethodVisitor mv) {
      var.load(mv);
      Type arrayType = Type.getType("[" + generator.getType().getDescriptor());
      WrapperType.OBJECT_PTR.emitUnpackArrayAndOffset(mv, Optional.of(arrayType));
    }

    @Override
    public void emitPushPtrRefForNullComparison(MethodVisitor mv) {
      var.load(mv);
      mv.visitFieldInsn(Opcodes.GETFIELD, Type.getInternalName(ObjectPtr.class), "array", "[Ljava/lang/Object;");
    }
  }
}
