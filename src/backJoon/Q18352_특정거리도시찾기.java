package backJoon;

import java.io.*;
import java.util.*;

public class Q18352_특정거리도시찾기 {

    static ArrayList<Integer>[] arr;
    static int[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        result = new ArrayList<>();
        bfs(x);
        for (int i = 1; i <= n; i++) {
            if (visited[i] == k) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]++;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (visited[i] == -1) {
                    q.add(i);
                    visited[now] = visited[node] + 1;
                }
            }
        }
    }
}
