package programmers;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Travel {
    int[][] map;
    List<Integer> answer = new LinkedList<>();

    public int[] solution(String[] maps) {

        // int 배열로 변환
        map = new int[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            char[] mapCharArr = maps[i].toCharArray();

            for(int j=0; j<mapCharArr.length; j++) {
                char c = mapCharArr[j];

                if(c == 'X' || c == 'x') {
                    map[i][j] = -1;
                }
                else {
                    // 1~9 라서 이렇게 해도 충분함.
                    map[i][j] = c - '0';
                }
            }
        }

        // dfs 알고리즘 수행
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                int islandSum = dfs(i, j);
                if(islandSum > 0) {
                    answer.add(islandSum);
                }
            }
        }

        // 무인도가 없으면 return -1
        if(answer.size() == 0) return new int[]{-1};

        // 무인도가 있으면 Sort후 int[] 형태로 반환
        Collections.sort(answer);
        int[] answerArr = new int[answer.size()];

        for(int i=0; i<answerArr.length; i++) answerArr[i] = answer.get(i);

        return answerArr;
    }

    public int dfs(int i, int j) {
        // 배열의 범위를 벗어나면 return
        if(i<0 || j<0 || i>=map.length || j>=map[0].length) {
            return 0;
        }
        // 이미 연산 대상에 포함된 상태면 return
        if(map[i][j] == -1) {
            return 0;
        }

        int tmp = map[i][j];
        map[i][j] = -1; // 들른 상태 저장

        // 사방으로 진행하며 같은 구역에 있는 값 탐색
        return tmp + dfs(i-1, j) + dfs(i+1, j) + dfs(i, j-1) + dfs(i, j+1);
    }
}