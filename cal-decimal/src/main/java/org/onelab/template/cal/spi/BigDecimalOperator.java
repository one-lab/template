package org.onelab.template.cal.spi;

import java.math.BigDecimal;

/**
 * 原子计算器的BigDecimal实现
 *
 * @author Chunliang.Han on 2019-03-21.
 */
public class BigDecimalOperator implements Operator {

  private static final String _0 = "0";

  @Override
  public String add(String a, String b) {
    return new BigDecimal(a.length() == 0 ? _0 : a).add(new BigDecimal(b)).toPlainString();
  }

  @Override
  public String subtract(String a, String b) {
    return new BigDecimal(a.length() == 0 ? _0 : a).subtract(new BigDecimal(b)).toPlainString();
  }

  @Override
  public String multiply(String a, String b) {
    return new BigDecimal(a).multiply(new BigDecimal(b)).toPlainString();
  }

  @Override
  public String divide(String a, String b, int scale, int roundingMode) {
    return new BigDecimal(a).divide(new BigDecimal(b), scale, roundingMode).toPlainString();
  }
}