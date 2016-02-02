package org.renjin.gcc.codegen.type.primitive.op;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.renjin.gcc.InternalCompilerException;
import org.renjin.gcc.codegen.MethodGenerator;
import org.renjin.gcc.codegen.expr.AbstractExprGenerator;
import org.renjin.gcc.codegen.expr.ExprGenerator;
import org.renjin.gcc.codegen.type.primitive.AddressOfPrimitiveValue;
import org.renjin.gcc.codegen.var.Value;
import org.renjin.gcc.gimple.GimpleOp;
import org.renjin.gcc.gimple.type.GimpleType;


public class MinMaxGenerator implements Value {

  private GimpleOp op;
  private Value x;
  private Value y;

  public MinMaxGenerator(GimpleOp op, Value x, Value y) {
    this.op = op;
    this.x = x;
    this.y = y;
  }

  @Override
  public Type getType() {
    return x.getType();
  }

  @Override
  public void load(MethodGenerator mv) {
    x.load(mv);
    y.load(mv);

    Type type = x.getType();
    if(!type.equals(y.getType())) {
      throw new UnsupportedOperationException(String.format(
          "Types must be the same: %s != %s", x.getType(), y.getType()));
    }
    
    String methodName;
    switch (op) {
      case MIN_EXPR:
        methodName = "min";
        break;
      case MAX_EXPR:
        methodName = "max";
        break;
      default:
        throw new IllegalArgumentException("op: " + op);
    }

    mv.invokestatic(Math.class, methodName, Type.getMethodDescriptor(type, type, type));
  }
}
