package org.onelab.template.tmp.salary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 个人所得税扣税参照表
 *
 * @author Chunliang.Han on 2019-04-15.
 */
public class TaxBook {

  /**
   * 扣税基数
   */
  BigDecimal base;

  /**
   * 对应税率
   */
  BigDecimal rate;

  /**
   * 速算扣除
   */
  BigDecimal deduct;

  private TaxBook(String base, String rate, String deduct) {
    this.base = new BigDecimal(base);
    this.rate = new BigDecimal(rate);
    this.deduct = new BigDecimal(deduct);
  }

  public static List<TaxBook> list;

  static {
    list = new ArrayList<>(7);
    list.add(new TaxBook("0", "0.03", "0"));
    list.add(new TaxBook("36000", "0.1", "2520"));
    list.add(new TaxBook("144000", "0.2", "16920"));
    list.add(new TaxBook("300000", "0.25", "31920"));
    list.add(new TaxBook("420000", "0.3", "52920"));
    list.add(new TaxBook("660000", "0.35", "85920"));
    list.add(new TaxBook("960000", "0.45", "181920"));
  }
}
