package org.onelab.template.tmp.salary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chunliang.Han on 2019-04-16.
 */
public class Demo {

  public static void main(String[] args) {

    List<Salary> salaries = new ArrayList<>();

    //录入薪酬
    for (int i = 0; i < 12; i++) {
      salaries.add(
          new Salary("35000", "59.4", "5000", "5641.90")
      );
    }

    //扣税计算
    TaxCalculator.calTax(salaries);

    //结果输出
    salaries.forEach(System.out::println);
  }
}
