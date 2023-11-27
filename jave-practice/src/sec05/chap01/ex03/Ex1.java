package sec05.chap01.ex03;

public class Ex1 {
    int age;

    String name;

    public Ex1(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void info(){
        System.out.printf("안녕하세요! %d살 %s 입니다.\n", age, name);
    }
}
