package ex1.test;

public abstract class Abc {
    protected static final String CREED = "우리의 %s 얄팍하다";

    protected final int no;
    protected final String name;

    public Abc(int no, String name){
        this.no = no;
        this.name = name;
    }

    public String intro(){
        return "%d호 %s점 입니다.".formatted(no, name);
    }

    public abstract void takeOrder();
}
