package sec03.chap01;

public class Ex04 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        //  int끼리 연산은 int 반환
        int c = a + b;

//        long d = a + b;
//        short e = a + b; // ⚠️ 묵시적으로는 불가
//        short f = (short) (a + b);

        byte b1 = 1;
        byte b2 = 2;
        short s1 = 1;
        short s2 = 2;

        //  ⚠️ 아래는 모두 불가
//        byte b3 = b1 + b2;
//        short s3 = b1 + b2;
//        short s4 = b1 + s2;
//        short s5 = s1 + s2;

        //  ⭐ byte와 short의 연산들은 int 반환
        //  그냥 int를 많이 쓰는 이유 중 하나
        int i1 = b1 + b2;
        int i2 = s1 + s2;
        int i3 = b1 + s1;
    }
}
