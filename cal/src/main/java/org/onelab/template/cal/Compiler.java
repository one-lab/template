package org.onelab.template.cal;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chunliang.Han on 2019-03-22.
 */
class Compiler {

  static final char SEG_1 = '+';
  static final char SEG_2 = '-';
  static final char SEG_3 = '*';
  static final char SEG_4 = '/';
  static final char SEG_5 = '(';
  static final char SEG_6 = ')';

  static final List<Character> SEG_L1 = Arrays.asList(SEG_1, SEG_2);
  static final List<Character> SEG_L2 = Arrays.asList(SEG_3, SEG_4);

  /**
   * 编译
   */
  CalculatorNode compile(String exp) {
    int index;
    exp = trim(exp);
    //加减运算符
    index = findSegIndex(exp, SEG_L1);
    if (index >= 0) {
      return compile(exp, index);
    }
    //乘除运算符
    index = findSegIndex(exp, SEG_L2);
    if (index >= 0) {
      return compile(exp, index);
    }
    return compile(exp, index);
  }

  private CalculatorNode compile(String exp, int index) {
    CalculatorNode calculatorNode = new CalculatorNode();
    if (index < 0) {
      calculatorNode.value = exp;
      return calculatorNode;
    }
    calculatorNode.opt = exp.charAt(index);
    calculatorNode.lNode = compile(exp.substring(0, index));
    calculatorNode.rNode = compile(exp.substring(index + 1));
    return calculatorNode;
  }

  /**
   * 去除无用左右括号
   *
   * @param exp 代数式
   */
  private String trim(String exp) {

    if (exp.length() == 0 || exp.charAt(0) != SEG_5) {
      return exp;
    }
    int cnt = 0;
    int tmpIndex = 0;
    for (int i = 0; i < exp.length(); i++) {
      if (exp.charAt(i) == SEG_5) {
        cnt++;
        continue;
      }
      if (exp.charAt(i) == SEG_6) {
        cnt--;
      }
      if (cnt == 0) {
        tmpIndex = i;
        break;
      }
    }
    if (tmpIndex + 1 == exp.length()) {
      return trim(exp.substring(1, exp.length() - 1));
    }
    return exp;
  }

  /**
   * 获取满足条件的符号位置
   *
   * @param exp  代数式
   * @param segs 运算符 + - * /
   */
  private int findSegIndex(String exp, List<Character> segs) {
    int cnt = 0;
    for (int i = exp.length()-1; i > -1; i--) {
      if (exp.charAt(i) == SEG_6) {
        cnt++;
      }
      if (exp.charAt(i) == SEG_5) {
        cnt--;
      }
      if (cnt == 0 && segs.contains(exp.charAt(i))) {
        return i;
      }
    }
    return -1;
  }
}