package org.onelab.template.lambda;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * getting start
 *
 * @author Chunliang.Han on 2019-01-10.
 */
public class Demo {

  public static void main(String[] args) {
    var s = new Demo();
    s.test();
  }

  void test() {
    var a = Stream.of(1, 2, 3);
    ArrayList arr = new ArrayList<Integer>();
    Consumer c = new Consumer<Integer>() {
      public ArrayList arr;

      @Override
      public void accept(Integer integer) {
        try {
          Method m = arr.getClass().getDeclaredMethod("println");
          m.invoke(a, integer);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    };
    try {
      c.getClass().getDeclaredField("arr").set(c, arr);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    a.forEach(c);
  }
}
