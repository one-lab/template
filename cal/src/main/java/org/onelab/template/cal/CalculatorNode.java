package org.onelab.template.cal;

/**
 * 运算节点
 *
 * @author Chunliang.Han on 2019-03-21.
 */
class CalculatorNode {

  /**
   * 操作符
   */
  char opt;

  /**
   * 操作数
   */
  String value;

  /**
   * 左代数式
   */
  CalculatorNode lNode;

  /**
   * 右代数式
   */
  CalculatorNode rNode;
}