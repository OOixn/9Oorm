package sec05.chap09.ex01;

public class A extends Mamal implements Swimmer {
    public A(){super( false);}
    @Override
    public void swim() {
        System.out.printf("와구 와구");
    }
}
