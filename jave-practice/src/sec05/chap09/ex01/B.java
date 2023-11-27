package sec05.chap09.ex01;

public class B extends Bird implements Hunter, Flyer{

    @Override
    public void fly() {
        System.out.printf("날개로 날아다닌다");
    }

    @Override
    public void hunt() {
        System.out.printf("날카로운 이빨로 사냥");
    }
}
