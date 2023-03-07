package backJoon.bruteForce;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = d(num);
        System.out.println(result);
    }

    private static int d(int num) {
        if (num < 100){
            return num;
        } else if (num == 1000) {
            return d(999);
        } else {
            int cnt = 99;
            for (int i = 100; i <= num; i++){
                int tmp = i;
                //1의 자리 수
                int a = tmp % 10;
                tmp /= 10;
                //10의 자리 수
                int b = tmp % 10;
                tmp /= 10;
                //100의 자리 수
                int c = tmp % 10;
                if((a-b) == (b-c)){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
