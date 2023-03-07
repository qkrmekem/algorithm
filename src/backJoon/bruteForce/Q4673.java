package backJoon.bruteForce;

public class Q4673 {
    // 셀프 넘버
    public static void main(String[] args) {
        boolean[]selfNum = new boolean[10001];

        for (int i = 1;i<=10000;i++){
            int cnt = d(i);

            if (cnt <= 10000){
                selfNum[cnt] = true;
            }
        }
        for (int i = 1; i<10001; i++){
            if (selfNum[i] == false){
                System.out.println(i);
            }
        }
    }

    private static int d(int i) {
        int cnt = i;

        while (i != 0){
            cnt += i % 10;
            i /= 10;
        }

        return cnt;
    }
}
