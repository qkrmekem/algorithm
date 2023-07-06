package backJoon;

import java.io.*;
import java.util.*;

public class Q1016_제곱이아닌수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long s = min / pow;
            if (min % pow != 0) {
                s++;
            }
            for (long j = s; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
