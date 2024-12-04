package day_240411.아기상어2_17086;
import java.io.*;
import java.util.*;
/**
 * 1. 문제 파악
 * 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수.
 * 이동 방향 8방향 - 델타배열
 * 안전 거리는 가장 가까운 아기 상어와의 거리
 * 
 * N,M : 2~50
 * 0 - 빈칸, 1 - 아기상어
 * 
 * 안전거리의 최댓값을 출력
 * 
 * 2. 접근 방법
 * 각 아기 상어의 위치에서 bfs를 수행합니다.(X)
 * 안전거리를 확인하기 위한 배열을 생성합니다. - int 배열
 * 안전거리 값이 겹치는 경우, 둘 중 최소값을 기준으로 안전거리를 넣습니다.
 * 1이 아니고 배열 범위 안에서만 이동
 * 안전 거리 중에서 최댓값을 출력 해줍니다.
 * 
 * 2-1
 * 빈칸에서 bfs를 수행합니다. 즉, 각 빈칸마다 현재 내 주위에 가장 가까이 있는 상어는 어디있는지를 기록!
 * 각 빈칸마다 초기화된 상태에서 상어를 찾아야하기 때문에, bfs 함수 내에서 방문배열, 큐 초기화
 * 그냥 이렇게 각 항마다 브루트포스처럼 찾아준다음에 최댓값 구해주면 되는 문제..
 * 어제 매니저님 말씀처럼 브루트포스 기준으로 먼저 생각해야겠다..ㅜ
 */
public class Main {
    static int[][] board;
    static boolean[][] visited;

    static int[] dr = {-1,-1,-1,0,1,1,1,0};// 왼위 ~ 왼쪽(시계)
    static int[] dc = {-1,0,1,1,1,0,-1,-1};
    static int row,col;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];

        for(int r=0; r<row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<col; c++){
                board[r][c] = Integer.parseInt(st.nextToken());            
            }
        }

        int tmp = 0;
        int count = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] != 1){
                    tmp = bfs(r,c);
                    count = Math.max(count,tmp);
                }
            }
        }

        br.close();

        System.out.println(count);
    }

    static int bfs(int r, int c){
        visited = new boolean[row][col];
        Queue<Coordinator> q = new LinkedList<>();
        q.offer(new Coordinator(r, c, 0));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Coordinator now = q.poll();

            for(int i=0; i<8; i++){
                int tr = now.cr + dr[i];
                int tc = now.cc + dc[i];
                int cnt = now.count + 1;

                if(tr < 0 || tc < 0 || tr >= row || tc >= col || visited[tr][tc]) continue;

                if(board[tr][tc] == 1) return cnt;

                q.offer(new Coordinator(tr,tc,cnt));

                visited[tr][tc] = true;
            }
        }

        return 0;
    }

    static class Coordinator{
        int cr; // Coordinator-Row
        int cc; // Coordinator-Col
        int count; // idea

        Coordinator(int cr, int cc, int count){
            this.cr = cr;
            this.cc = cc;
            this.count = count;
        }
    }
}
