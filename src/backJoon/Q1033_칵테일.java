package backJoon;

import java.util.*;

public class Q1033_칵테일 {
    static ArrayList<Node>[] arr;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < n - 1; i++) {
            // 노드
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a와 b의 비율값
            // a의 비율
            int p = sc.nextInt();
            // b의 비율
            int q = sc.nextInt();
            // 각 노드에 간선을 추가
            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            //각 재료들의 최소 공배수를 구함
            lcm *= (p * q / gcd(p, q));
        }
        // 임의의 노드 0을 기준으로 비율을 계산하기 위해
        // 0번째 노드에 최소공배수를 저장
        d[0] = lcm;
        dfs(0);
        // 기준값(최소공배수)을 이용해 각 노드의 최대 공약수를 구함
        long mgcd = d[0];
        for (int i = 1; i < n; i++) {
            //모든 노드들의 최대 공약수
            mgcd = gcd(mgcd, d[i]);
        }
        for (int i = 0; i < n; i++) {
            // 최소값을 출력해야 하므로
            // 각 노드의 값과 최대공약수를 나눠 최소값을 출력
            System.out.print(d[i]/mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (Node i : arr[node]) {
            int next = i.b;
            if (!visited[next]) {
                // 현재 노드의 값과 다음 노드의 비율을 계산해 다음 노드의 값을 구함
                // 현재노드의 값 * 다음 노드의 비율 / 현재노드의 비율
                d[next] = d[node] * i.q / i.p;
                dfs(next);
            }
        }
    }
}

class Node{
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }
}
