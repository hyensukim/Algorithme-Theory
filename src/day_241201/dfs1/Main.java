package day_241201.dfs1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            graph = new int[x][y];
            visited = new boolean[x][y];
            
            for(int i=0; i<count; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                graph[row][col] = 1;
            }
            
            int result = 0;
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        result++;
                    }
                }
            }
            
            System.out.println(result);
        }
    }
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(row < 0 || col < 0 || graph.length <= row || graph[0].length <= col){
                continue;
            }
            if(!visited[row][col] && graph[row][col] == 1){
                dfs(row,col);
            }
        }
    }
}
