package sec05.chap09.ex01;

public class C extends Reptile implements Flyer, Hunter{

    @Override
    public void fly() {
        System.out.printf("그냥 멋지게 날아버림");
    }

    @Override
    public void hunt() {
        System.out.printf("그냥 멋있게 사냥해버림");
    }
}
