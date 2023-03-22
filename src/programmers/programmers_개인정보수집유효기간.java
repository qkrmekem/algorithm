package programmers;

import java.util.*;

public class programmers_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];

        Map map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String tmp = terms[i].split(" ")[0];
            String term = terms[i].split(" ")[1];
            map.put(tmp, term);
        }

        for(int y = 0; y < privacies.length; y++){
            String days = privacies[y].split(" ")[0].replace(".", "");
            String ttmp = privacies[y].split(" ")[1];

            Integer dayInt = Integer.parseInt(days);
            term = map.get(ttmp);
            System.out.println(days);
        }




        return answer;
    }
}
