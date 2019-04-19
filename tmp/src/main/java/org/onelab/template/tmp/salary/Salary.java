package org.onelab.template.tmp.salary;

import java.math.BigDecimal;

import lombok.ToString;
import lombok.NoArgsConstructor;

/**
 * 薪酬对象
 *
 * @author Chunliang.Han on 2019-04-15.
 */
@ToString
@NoArgsConstructor
public class Salary {

  /**
   * 当期税前收入
   */
  BigDecimal base;

  /**
   * 当期扣除金额
   */
  BigDecimal deduct;

  /**
   * 附加计税金额
   */
  BigDecimal adds;

  /**
   * 减免计税金额
   */
  BigDecimal subs;

  /**
   * 当期税后实收
   */
  BigDecimal real;

  /**
   * 当期缴税金额
   */
  BigDecimal tax;

  /**
   * 历史应税总额
   */
  BigDecimal hisSum;

  /**
   * 历史缴税总额
   */
  BigDecimal hisTax;

  public Salary(String base, String adds, String subs, String deduct) {
    this.base = new BigDecimal(base);
    this.adds = new BigDecimal(adds);
    this.subs = new BigDecimal(subs);
    this.deduct = new BigDecimal(deduct);
  }
}
