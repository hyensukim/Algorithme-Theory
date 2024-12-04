package day_240414.PutoPuyo_11559;

import java.io.*;
import java.util.*;

/**
 * 
 * 
 * 
 * 1. 문제 파악
 * 뿌요 행동
 * - 뿌요는 아래에 바닥, 다른 뿌요가 나올때까지 아래로 떨어진다.
 * - 뿌요가 이동 후, 같은 색이 4개 이상 상하좌우로 연결? 되어 있으면 사라진다.
 * - 뿌요들이 없어진 공간 위에 다른 뿌요가 있으면, 해당 뿌요는 다시 떨어진다.
 * - 위의 과정을 반복하여 한번 사라질때마다 1연쇄씩 카운팅한다.
 * - 동시에 터지는 경우 1연쇄로 간주한다.
 * 
 * 입력
 * - 총 12개 줄에 6개의 문자 입력, '.' 은 빈공간, !'.'은 색깔의 뿌요 존재
 * - 뿌요 색 : R, G, B, P, Y
 * 
 * 출력
 * - 몇연쇄가 발생하는지 출력, 아예 없으면 0출력
 * 
 * 
 * 2. 구현 포인트
 * - 4개 이상의 똑같은 뿌요를 확인하기 위해서 bfs 내부에 별도로 List에 해당 뿌요(좌표값)를 담도록해줘야 합니다.
 * - 이를 위해서는 List에 담아야할 뿌요의 색을 bfs 시작과 동시에 알고 있어야 합니다.
 */
public class Main {
    static char[][] board;
    static boolean[][] visited;
    static final int n = 12;
    static final int m = 6;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[n][m];

        for(int i=0; i<12; i++){
            board[i] = br.readLine().toCharArray();
        }

        int result = 0;
        while(true){

            visited = new boolean[n][m];

            // 1. 4개 이상의 뿌요 확인 후 없애기
            boolean isChaning = false;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    char ch = board[i][j];
                    if(ch != '.'){
                        List<Puyo> li = bfs(i, j);
                        if(li.size() >= 4){
                            isChaning = true;
                            for(Puyo puyo : li){
                                board[puyo.x][puyo.y] = '.';
                            }
                        }
                    }
                }
            }

            // 2. 내리기
            if(!isChaning){
                break;
            }
            else{
                fall();
                result++;
            }
        }

        br.close();

        System.out.println(result);
    }

    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {-1,0,1,0};

    static List<Puyo> bfs(int x, int y){ // dfs
        Queue<Puyo> q = new LinkedList<>();
        q.offer(new Puyo(x,y));
        visited[x][y] = true;

        List<Puyo> li = new ArrayList<>();
        li.add(new Puyo(x,y));
        
        char ch = board[x][y];

        while(!q.isEmpty()){
            Puyo puyo = q.poll();

            for(int i=0; i<4; i++){
                int nx = puyo.x + dx[i];
                int ny = puyo.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && ch == board[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new Puyo(nx,ny));
                        li.add(new Puyo(nx,ny));
                    }
                }
            }
        }

        return li;
    }

    static void fall(){
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(board[j][i] == '.'){
                    for(int k = j-1; k>=0; k--){
                        if(board[k][i] != '.'){
                            char ch = board[k][i];
                            board[j][i] = ch;
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Puyo{
        int x;
        int y;

        Puyo(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}