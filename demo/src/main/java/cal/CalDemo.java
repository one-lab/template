package cal;

import org.onelab.template.cal.Calculator;

/**
 * @author Chunliang.Han on 2019-04-19.
 */
public class CalDemo {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    System.out.println(calculator.getOperatorClass());
    System.out.println(calculator.calculate("17/3", 2));
  }
}
