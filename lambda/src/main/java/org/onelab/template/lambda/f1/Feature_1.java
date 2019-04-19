package org.onelab.template.lambda.f1;

/**
 * @author Chunliang.Han on 2019-01-11.
 */
public class Feature_1 {

  public static void main(String[] args){
    var f = new Feature_1();
    System.out.println(f.max(3,5));
  }

  int max(int a, int b){
    return fab(Integer::max, a, b);
  }

  private int fab(F f, int a, int b){
    return f.apply(a, b);
  }
}

interface F {
  int apply(int a, int b);
}
