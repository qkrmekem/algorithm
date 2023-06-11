package backJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10986_나머지합구하기 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        int size = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[] input = new int[size+1];
//        int[] sum = new int[size+1];
//        st = new StringTokenizer(bf.readLine());
//        int nam = 0;
//        int nnam = 0;
//        for (int i = 1; i <= size; i++){
//            int tmp = Integer.parseInt(st.nextToken());
//            input[i] = tmp;
//            sum[i] = sum[i-1] + tmp % m;
//            if (sum[i] == 0){
//                nam++;
//            }else {
//                nnam++;
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n];
        long[] c = new long[m];
        long answer = 0;
        s[0] = sc.nextInt();
        for (int i = 1; i < n; i++){
            s[i] = s[i - 1] + sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            int remainder = (int) (s[i] % m);
            if (remainder==0){
                answer++;
            }
            c[remainder]++;
        }
        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                answer = answer + (c[i] * (c[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}
