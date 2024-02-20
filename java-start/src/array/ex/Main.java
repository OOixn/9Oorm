package array.ex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int solution = 0;

        if(a == b && b == c){
           solution =  10000 + a * 1000;
        } else if( a == b || b == c){
             solution = 1000 + b * 100;
        } else if(a == c ){
            solution = 1000 + c * 100;
        }else {
             solution = Math.max(Math.max(a, b), c) * 100;
        }

        System.out.println(solution);
    }
}


