package backJoon;

import java.util.*;

public class Q21568_AxByC {

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        gcd(a, b);
        if (c % result != 0) {
            System.out.println(-1);
        } else {
            int mok = c/result;
            long[] ret = excute(a, b);
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    public static long[] excute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    public static void gcd(int a, int b) {
        if (b == 0) {
            result = a;
            return;
        }
        int nam = a % b;
        gcd(b, nam);
    }
}
