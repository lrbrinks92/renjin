/**
 * Renjin : JVM-based interpreter for the R language for the statistical analysis
 * Copyright © 2010-2016 BeDataDriven Groep B.V. and contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, a copy is available at
 * https://www.gnu.org/licenses/gpl-2.0.txt
 */
package org.renjin.gcc.codegen.fatptr;

import org.renjin.gcc.codegen.MethodGenerator;
import org.renjin.gcc.codegen.expr.*;
import org.renjin.repackaged.asm.Label;
import org.renjin.repackaged.asm.Type;

public class DereferencedFatPtr implements RefPtrExpr, FatPtr {

  private final ValueFunction valueFunction;
  private JExpr array;
  private JExpr offset;
  private Type wrapperType;

  public DereferencedFatPtr(JExpr array, JExpr offset, ValueFunction valueFunction) {
    this.array = array;
    this.offset = offset;
    this.valueFunction = valueFunction;
    this.wrapperType = Wrappers.wrapperType(valueFunction.getValueType());
  }

  private ArrayElement element() {
    return Expressions.elementAt(array, offset);
  }
  
  private JExpr castedElement() {
    return Expressions.cast(element(), wrapperType);
  }

  @Override
  public JExpr unwrap() {
    return element();
  }

  @Override
  public void store(MethodGenerator mv, GExpr rhs) {

    if(rhs instanceof FatPtr) {
      element().store(mv, ((FatPtr) rhs).wrap());

    } else {
      throw new UnsupportedOperationException("TODO: " + rhs.getClass().getName());
    }
  }

  @Override
  public GExpr addressOf() {
    return new FatPtrPair(valueFunction, array, offset);
  }

  @Override
  public Type getValueType() {
    return valueFunction.getValueType();
  }

  @Override
  public boolean isAddressable() {
    return false;
  }

  @Override
  public JExpr wrap() {
    return element();
  }

  @Override
  public FatPtrPair toPair(MethodGenerator mv) {
    return Wrappers.toPair(mv, valueFunction, castedElement());
  }

  @Override
  public void jumpIfNull(MethodGenerator mv, Label label) {
    element().load(mv);
    mv.ifnull(label);
  }

  @Override
  public GExpr valueOf() {
    throw new UnsupportedOperationException("TODO");
  }
}
