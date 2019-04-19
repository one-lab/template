package org.onelab.template.lambda.f0;

import java.util.function.Function;

/**
 * @author Chunliang.Han on 2019-01-11.
 */
public class Feature {

  public static void main(String[] args) {
    var f = new Feature();
    f.testFunction();
  }

  void testFunction(){
    Function<String, Integer> f1 = Integer::parseInt;
    f1.apply("1");
    Function<String, Integer> f2 = s -> Integer.parseInt(s);
    f2.apply("2");
    Function<String, Integer> f3 = s -> {return Integer.parseInt(s);};
    f3.apply("3");
    Function<String, Integer> f4 = (s) -> {return Integer.parseInt(s);};
    f4.apply("4");
    Function<String, Integer> f5 = new Function<String, Integer>() {
      @Override
      public Integer apply(String s) {
        return Integer.parseInt(s);
      }
    };
    f5.apply("5");
  }
}
