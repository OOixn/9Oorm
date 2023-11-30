package loop.ex;

import java.util.Scanner;

public class ForEx4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int o = sc.nextInt();
        int s = sc.nextInt();

        for(int i=o; i <= s; i++){
            for(int j=1; j <= 9; j++){
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }
}
