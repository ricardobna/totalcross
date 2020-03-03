/*********************************************************************************
 *  TotalCross Software Development Kit                                          *
 *  Copyright (C) 2000-2012 SuperWaba Ltda.                                      *
 *  Copyright (C) 2012-2020 TotalCross Global Mobile Platform Ltda.              *
 *  All Rights Reserved                                                          *
 *                                                                               *
 *  This library and virtual machine is distributed in the hope that it will     *
 *  be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                         *
 *                                                                               *
 *  This file is covered by the GNU LESSER GENERAL PUBLIC LICENSE VERSION 3.0    *
 *  A copy of this license is located in file license.txt at the root of this    *
 *  SDK or can be downloaded here:                                               *
 *  http://www.gnu.org/licenses/lgpl-3.0.txt                                     *
 *                                                                               *
 *********************************************************************************/

package tc.tools.converter.ir.Instruction;

import tc.tools.converter.TCConstants;
import tc.tools.converter.tclass.TCCode;
import totalcross.util.Vector;

public class Reg_sym extends SingleInstruction {
  public int reg;
  public int sym;

  public Reg_sym(int op, int line, int r, int s) {
    super(op, line);
    reg = r;
    sym = s;
  }

  public Reg_sym(int op, int line) {
    super(op, line);
  }

  public void set(int r, int s) {
    reg = r;
    sym = s;
  }

  @Override
  public String toString() {
    String print;
    print = TCConstants.bcTClassNames[opcode] + "  " + reg + ", " + sym;
    return print;
  }

  @Override
  public void toTCCode(Vector vcode) {
    TCCode tc = new TCCode(opcode, line);
    tc.reg_sym__reg(reg);
    tc.reg_sym__sym(sym);
    vcode.addElement(tc);
  }
}