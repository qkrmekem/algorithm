package backJoon;

import java.io.*;
import java.util.*;

public class Q2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > s){
                s = arr[i];
            }
            e += arr[i];
        }
        while (true) {
            int mid = (s + e) / 2;
            int cnt = 1;
            int tmp = 0;
            for (int i = 1; i <= n; i++) {
                tmp += arr[i];
                if (tmp > mid) {
                    cnt++;
                    tmp = arr[i];
                }
            }
            if (cnt > m) {
                s = mid + 1;
            }else {
                e = mid - 1;
            }
            if (s > e) {
                System.out.println(s);
                break;
            }
        }
    }
}
