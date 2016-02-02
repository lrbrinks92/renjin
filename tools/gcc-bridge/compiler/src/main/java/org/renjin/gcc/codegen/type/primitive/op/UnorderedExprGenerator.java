package org.renjin.gcc.codegen.type.primitive.op;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.renjin.gcc.codegen.MethodGenerator;
import org.renjin.gcc.codegen.var.Value;

/**
 * Determines whether {@code x} and {@code y} are "unordered", that is, 
 * if one or both arguments are NaN.
 */
public class UnorderedExprGenerator implements Value {
  
  private Value x;
  private Value y;

  public UnorderedExprGenerator(Value x, Value y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Type getType() {
    return Type.BOOLEAN_TYPE;
  }

  @Override
  public void load(MethodGenerator mv) {
    Label unordered = new Label();
    Label exit = new Label();
    
    emitIsNaN(mv, x);
    // 1 = not a number
    // 0 = not (not a number)
    // If not equal to zero, then x is 
    mv.ifne(unordered);
    
    // If x was not NaN, then we have to check y too
    emitIsNaN(mv, y);
    mv.ifne(unordered);
    
    // Ordered!
    mv.iconst(0);
    mv.goTo(exit);
    
    // Unordered
    mv.mark(unordered);
    mv.iconst(1);
    
    // Exit
    mv.mark(exit);
  }

  private void emitIsNaN(MethodGenerator mv, Value value) {
    value.load(mv);

    switch (value.getType().getSort()) {
      case Type.DOUBLE:
        mv.invokestatic(Double.class, "isNaN", Type.getMethodDescriptor(Type.BOOLEAN_TYPE, Type.DOUBLE_TYPE));
        break;
      
      case Type.FLOAT:
        mv.invokestatic(Double.class, "isNaN", Type.getMethodDescriptor(Type.BOOLEAN_TYPE, Type.FLOAT_TYPE));
        break;          
    
      default:
        throw new IllegalStateException("type: " + value.getType());
    }
  }
}
