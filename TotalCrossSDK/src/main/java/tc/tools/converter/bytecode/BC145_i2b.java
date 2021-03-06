// Copyright (C) 2000-2013 SuperWaba Ltda.
// Copyright (C) 2014-2020 TotalCross Global Mobile Platform Ltda.
//
// SPDX-License-Identifier: LGPL-2.1-only
package tc.tools.converter.bytecode;

public class BC145_i2b extends Conversion // this conversion should be ignored
{
  public BC145_i2b() {
    super(-1, -1, INT, BYTE);
  }

  @Override
  public void exec() {
    stack[stackPtr - 1].asInt = (byte) stack[stackPtr - 1].asInt;
  }
}
