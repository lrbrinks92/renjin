package org.renjin.gcc.codegen.type.primitive.op;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.renjin.gcc.codegen.MethodGenerator;
import org.renjin.gcc.codegen.expr.AbstractExprGenerator;
import org.renjin.gcc.codegen.expr.ExprGenerator;
import org.renjin.gcc.codegen.type.primitive.AddressOfPrimitiveValue;
import org.renjin.gcc.codegen.var.Value;
import org.renjin.gcc.gimple.type.GimpleType;

/**
 * Generates the bytecode to negate a numeric value
 */
public class NegateGenerator implements Value {
  
  private Value operand;

  public NegateGenerator(Value operand) {
    this.operand = operand;
  }

  @Override
  public Type getType() {
    return operand.getType();
  }

  @Override
  public void load(MethodGenerator mv) {
    operand.load(mv);
    mv.neg(operand.getType());

  }
}
