package org.onelab.template.tmp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chunliang.Han on 2019-03-29.
 */
public class TextParser {

  static Pattern pattern = Pattern.compile("(>|<|=|\\s+like\\s+)",  Pattern.CASE_INSENSITIVE);

  public static void main(String[] args) {
    String exp = "a.ssh.y[90]           LIke      'dddd' < > = ";
    Matcher matcher = pattern.matcher(exp);
    if (matcher.find()){
      String s = matcher.group(1);
      int i = exp.indexOf(s);
      System.out.println(exp.substring(0,i));
      System.out.println(exp.substring(i));
    }
  }
}
