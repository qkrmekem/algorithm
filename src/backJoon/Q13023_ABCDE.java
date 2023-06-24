package backJoon;

import java.io.*;
import java.util.*;

public class Q13023_ABCDE {

    static LinkedList<Integer>[] arr;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new LinkedList[node];
        visited = new boolean[node];
        result = 0;

        for (int i = 0; i < node; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].push(e);
            arr[e].push(s);
        }

        for (int i = 0; i < node; i++) {
            if (result == 1) {
                break;
            }
            if (!visited[i]) {
                dfs(i, 1);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int node, int depth) {
        if (visited[node]) {
            return;
        }
        if (depth == 5) {
            result = 1;
            return;
        }
        visited[node] = true;
        for (int i : arr[node]) {
            if (visited[i] == false) {
                dfs(i,depth + 1);
            }
        }
        visited[node] = false;
    }
}
