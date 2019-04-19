package org.onelab.template.tmp.salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 新税法个人所得税计算器
 *
 * @author Chunliang.Han on 2019-04-16.
 */
public class TaxCalculator {

  /**
   * 计算给定序列的薪酬
   */
  public static void calTax(List<Salary> salaries) {

    //上期收入
    Salary lastSalary = null;

    for (Salary salary : salaries) {

      //计算历史合计
      fuFill(lastSalary, salary);

      //计算当期扣税金额
      calTax(salary);

      lastSalary = salary;
    }
  }

  public static void calTax(Salary salary) {

    //应税金额
    BigDecimal plan =
        salary.hisSum.add(salary.base).add(salary.adds).subtract(salary.subs)
            .subtract(salary.deduct);

    //税收金额
    salary.tax = BigDecimal.ZERO;
    for (int i = 0, len = TaxBook.list.size(); i < len; i++) {
      TaxBook taxBook = TaxBook.list.get(len - i - 1);
      if (plan.compareTo(taxBook.base) > 0) {
        salary.tax =
            plan.multiply(taxBook.rate).subtract(salary.hisTax).subtract(taxBook.deduct)
                .setScale(2, RoundingMode.HALF_UP);
        break;
      }
    }

    //税后实收
    salary.real =
        salary.base.subtract(salary.tax)
            .subtract(salary.deduct).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 计算历史合计
   */
  private static void fuFill(Salary lastSalary, Salary salary) {
    if (lastSalary != null) {
      salary.hisSum =
          lastSalary.hisSum.add(lastSalary.base).add(lastSalary.adds)
              .subtract(lastSalary.subs)
              .subtract(lastSalary.deduct);
      salary.hisTax = lastSalary.hisTax.add(lastSalary.tax);
    } else {
      salary.hisSum = salary.hisTax = BigDecimal.ZERO;
    }
  }
}
