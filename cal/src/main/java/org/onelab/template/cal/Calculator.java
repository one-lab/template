package org.onelab.template.cal;

import java.math.BigDecimal;

/**
 * 支持四则运算的计算器
 *
 * @author Chunliang.Han on 2019-03-21.
 */
public class Calculator {

  private static final String EMPTY = "";
  private static final String REPLACEABAL = "\\s|,";

  /**
   * 编译器
   */
  private Compiler compiler;

  /**
   * 原子计算器
   */
  private Operator operator;

  public Calculator() {
    this(DefaultOperator.class);
  }

  public Calculator(Class<? extends Operator> operatorClass) {
    compiler = new Compiler();
    try {
      operator = operatorClass.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 四舍五入取整
   */
  public String calculate(String exp) {
    return calculate(exp, 0);
  }

  /**
   * 四舍五入保留 scale 位小数
   */
  public String calculate(String exp, int scale) {
    return calculate(exp, scale, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 给定 roundingMode 保留 scale 位小数
   *
   * @param exp          代数式
   * @param scale        同BigDecimal，默认保留0位
   * @param roundingMode 同BigDecimal, 默认使用BigDecimal.ROUND_HALF_UP
   */
  public String calculate(String exp, int scale, int roundingMode) {
    String cleanExp = exp.replaceAll(REPLACEABAL, EMPTY);
    CalculatorNode node = compiler.compile(cleanExp);
    return calculate(node, scale, roundingMode);
  }

  /**
   * 运算
   */
  private String calculate(CalculatorNode node, int scale, int roundingMode) {
    if (node.value == null) {
      switch (node.opt) {
        case Compiler.SEG_1:
          return
              operator.add(
                  calculate(node.lNode, scale, roundingMode),
                  calculate(node.rNode, scale, roundingMode)
              );
        case Compiler.SEG_2:
          return
              operator.subtract(
                  calculate(node.lNode, scale, roundingMode),
                  calculate(node.rNode, scale, roundingMode)
              );
        case Compiler.SEG_3:
          return
              operator.multiply(
                  calculate(node.lNode, scale, roundingMode),
                  calculate(node.rNode, scale, roundingMode)
              );
        case Compiler.SEG_4:
          return
              operator.divide(
                  calculate(node.lNode, scale, roundingMode),
                  calculate(node.rNode, scale, roundingMode), scale, roundingMode
              );
        default:
      }
    }
    return node.value;
  }
}
