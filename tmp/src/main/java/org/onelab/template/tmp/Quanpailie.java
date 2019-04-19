package org.onelab.template.tmp;

/**
 * @author Chunliang.Han on 2019-04-12.
 */
public class Quanpailie {

  private int w;
  private int[] iterms;

  private int r;

  public Quanpailie(int[] iterms, int w){
    this.w = w;
    this.iterms = iterms;
  }

  public int execute(){
    r = 0;
    exe(0, 0);
    return r;
  }

  public void exe(int i, int sum){

    //终止
    if (sum > w) return;

    //冒泡
    if (sum > r) r = sum;;

    //接续
    if (i < iterms.length){
      //抛弃当前节点数值并操作子串
      exe(i+1, sum);
      //选择当前节点数值并操作子串
      exe(i+1, sum + iterms[i]);
    }
  }

  public static void main(String[] args){
    Quanpailie quanpailie = new Quanpailie(new int[]{3,6,9,4}, 17);
    System.out.println(quanpailie.execute());
  }
}
