package ex1.test;

public class Abc1 extends Abc{
    public static String getCreed(){
        return CREED.formatted("튀김옷은");
    }
    protected  static int lastNo = 0;
    public Abc1(String name){
        super(++lastNo, name);
    }
 @Override
 public void takeOrder(){
     System.out.printf("치킨을 주문해 주세요%n", super.intro());
 }
}
