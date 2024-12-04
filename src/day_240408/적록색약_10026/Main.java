package day_240408.적록색약_10026;
import java.io.*;
import java.util.*;
/**
 * 15988 KB
 * 168ms
 * 30분
 * O(N^2)
 * 
 * 1.문제파악
 * 크기 N x N
 * R,G,B 중 하나로 색칠
 * 상하좌우 인접한 같은색은 하나의 같은 영역
 * 적록색약인 사람의 경우, R과 G가 같은 색으로 보인다.
 * 
 * 적록색약인 사람과 아닌 사람이 봤을 때 각각의 구역 수를 구하시오.
 * 
 * N : 1~100
 * "비적록색약 구역수_적록색약 구역수" 출력('_' : 공백 의미)
 * 
 * 2. 접근방법
 * dfs 사용, 분기를 나눠서 최대한 많은 색영역으로 들어가는 dfs를 활용.
 * 비적록색약의 구역수는 RGB로 구분하여 구역수 카운팅.
 * 적록색약의 구역수는 R을 G로 변경하여 구역수 카운팅.
 * 구역수는 한번의 분기(최대깊이까지 들어가는게 한 분기)마다 카운팅해줌.
 */
public class Main {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean[][] visited;
    static String[][] colors;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        colors = new String[n][n];
        for(int i=0; i<n; i++){
            colors[i] = br.readLine().split("");
        }

        br.close();

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count);
        System.out.print(" ");

        for(int i=0; i<n; i++){
            Arrays.fill(visited[i],false);
            for(int j=0; j<n; j++){
                if("R".equals(colors[i][j])){
                    colors[i][j] = "G";
                }
            }
        }
        count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count);

    }

    static void dfs(int r, int c){
        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int row = r + dr[i];
            int col = c + dc[i];

            if(row < 0 || col < 0 || row >= n || col >= n) continue;

            if(!visited[row][col] && colors[r][c].equals(colors[row][col])){
                dfs(row,col);
            }
        }
    }
}
