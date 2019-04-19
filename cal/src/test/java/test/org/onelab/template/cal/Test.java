package test.org.onelab.template.cal;

import org.onelab.template.cal.Calculator;

/**
 * @author Chunliang.Han on 2019-03-22.
 */
public class Test {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    System.out.println(calculator.calculate("1"));//1
    System.out.println(calculator.calculate("+1"));//1
    System.out.println(calculator.calculate("-1"));//-1
    System.out.println(calculator.calculate("1+2"));//3
    System.out.println(calculator.calculate("1+2+3"));//6
    System.out.println(calculator.calculate("1-2-3"));//-4 *
    System.out.println(calculator.calculate("1+2-3"));//0
    System.out.println(calculator.calculate("1+2-(3-4)"));//4
    System.out.println(calculator.calculate("(1+2)-3-4"));//-4 *
    System.out.println(calculator.calculate("(1+2)-(3-4)"));//4
    System.out.println(calculator.calculate("2*3"));//6
    System.out.println(calculator.calculate("4/2"));//2
    System.out.println(calculator.calculate("(1+2)*4/3"));//4
    System.out.println(calculator.calculate("(1+2)*\n\t\n4/3"));//4
    System.out.println(calculator.calculate("((1+2)*4/3)"));//4
    System.out.println(calculator.calculate("(((1+2)*4/3))"));//4
    System.out.println(calculator.calculate("(((1+2)*4/3-(1+7)))"));//-4
    System.out.println(calculator.calculate("11111111,1111,1111 1111111111111111111111111111"
                                            + "11111111111111111111111111111111111111111111111111"
                                            + "1111*111111111111111111111111111111111111111111111"
                                            + "11*11111111111111111111111111111111111111111111111"
                                            + "11111111111111111111111111111111111111111111111111"
                                            + "1"));//-4
  }
}
