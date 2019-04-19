package cal.spi;

import org.onelab.template.cal.spi.Operator;

/**
 * 原子计算器的BigDecimal实现
 *
 * @author Chunliang.Han on 2019-03-21.
 */
public class SimpleOperator implements Operator {

  private static final String _0 = "0";

  @Override
  public String add(String a, String b) {
    return Integer.parseInt(a) + Integer.parseInt(b) + "";
  }

  @Override
  public String subtract(String a, String b) {
    return Integer.parseInt(a) - Integer.parseInt(b) + "";
  }

  @Override
  public String multiply(String a, String b) {
    return Integer.parseInt(a) * Integer.parseInt(b) + "";
  }

  @Override
  public String divide(String a, String b, int scale, int roundingMode) {
    return Integer.parseInt(a) / Integer.parseInt(b) + "";
  }
}