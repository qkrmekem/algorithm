package backJoon;

import java.util.*;

public class Q1747_소수와팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] != 0) {
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = 0;
                }
            }
        }
        int result = 0;
        int idx = n;
        while (true) {
            if (arr[idx] != 0) {
                char[] tmp = String.valueOf(arr[idx]).toCharArray();
                int s = 0;
                int e = tmp.length - 1;
                boolean check = true;
                while (s < e) {
                    if (tmp[s] != tmp[e]) {
                        check = false;
                        break;
                    }
                    s++;
                    e--;
                }
                if (check) {
                    result = idx;
                    break;
                }
            }
            idx++;
        }
        System.out.println(result);
    }
}