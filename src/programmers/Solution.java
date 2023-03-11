package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 공백
        // 키 내 중복
        // 키간 중복
        int[] answer = new int[targets.length];
        Set<String> s = new HashSet<>(Arrays.asList(keymap));
        s.remove("");

        for(int i = 0; i < targets.length; i++){
            answer[i] = 0;
            for(int y = 0; y < targets[i].length(); y++){
                int min = 101;
                for(String str : s){
                    int idx = str.indexOf(targets[i].charAt(y));
                    if(idx != -1){
                        if(idx < min){
                            min = idx;
                        }
                    }
                }
                if(min == 101){
                    answer[i] = -1;
                    break;
                }else{
                    answer[i] += min+1;
                }
            }
        }

        return answer;
    }
}
