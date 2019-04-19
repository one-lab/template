package org.onelab.template.cal;

/**
 * 原子计算器
 *
 * @author Chunliang.Han on 2019-03-21.
 */
public interface Operator {

  /**
   * 加法运算
   */
  String add(String a, String b);

  /**
   * 减法运算
   */
  String subtract(String a, String b);

  /**
   * 乘法运算
   */
  String multiply(String a, String b);

  /**
   * 除法运算
   */
  String divide(String a, String b, int scale, int roundingMode);
}