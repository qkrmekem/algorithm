package programmers;

import java.util.*;

public class Travel {
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};


    static boolean visited[][];
    static char[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();

    public Integer[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];

        map = new char[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    bfs(new Pos(i, j));
                }
            }
        }

        Collections.sort(answer);

        if(answer.size() == 0) answer.add(-1);

        return answer.toArray(new Integer[0]);
    }
    public static void bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        int sum = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();

            sum += map[cur.x][cur.y] - '0';
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(check(nx,ny) && !visited[nx][ny]){
                    q.add(new Pos(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        answer.add(sum);


    }

    public static boolean check(int nx, int ny){
        return (nx >=0 && nx < map.length && ny >=0 && ny <map[0].length
                && map[nx][ny] != 'X') ? true : false;
    }

}

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}