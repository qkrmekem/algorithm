package backJoon;

import java.io.*;
import java.util.*;

public class Q11004_k번째수 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[k-1]);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quick(arr, 0, n-1, k-1);
        System.out.println(arr[k-1]);
    }

    public static void quick(int[] arr, int s, int e, int k) {
        if (s < e){
            int pivot = getPivot(arr, s, e);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                quick(arr, s, pivot-1, k);
            } else {
                quick(arr, pivot + 1, e, k);
            }
        }

    }
    public static int getPivot(int[] arr, int s, int e) {
        if (s + 1 == e) {
            if (arr[s] > arr[e]) {
                swap(arr, s, e);
            }
            return e;
        }
        int mid = (s + e) / 2;
        swap(arr, s, mid);
        int pivot = arr[s];
        int i = s + 1;
        int j = e;
        while (i <= j) {
            while (j >= s + 1 && pivot < arr[j]) {
                j--;
            }
            while (i <= e && pivot > arr[i]) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int s, int e) {
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }

}
