package backJoon;

import java.io.*;
import java.util.*;

public class Q1325_효율적으로해킹하기 {

    static ArrayList<Integer>[] arr;
    static boolean visited[];
    static int result[];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        result = new int[n + 1];

        // 방문 배열 초기화
//        visited = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            visited[i] = -1;
//        }
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 에지 정보 초기화
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, 1);
                visited = new boolean[n+1];
            }
        }

        max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int node, int depth) {
        visited[node] = true;
        result[node]++;
        for (int next : arr[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
//        visited[node] = -1;
    }
}
