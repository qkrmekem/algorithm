package backJoon;

import java.util.*;

public class Q1253_좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++){
            int start = 0;
            int end = i-1;
            long sum = arr[i];
            while (start<end){
                if (arr[start] + arr[end] == sum){
                    if (start != i && end != i){
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }else if(arr[start] + arr[end] > sum){
                    end--;
                }else {
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}
