package day_241201.dfs2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> areas;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph = new int[x][y];
        visited = new boolean[x][y];
        
        for(int i=0; i<x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<y; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int paintCount = 0;
        areas = new ArrayList<>();
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    areas.add(dfs(i,j,0));
                    paintCount++;
                }
            }
        }
        
        int maxArea = 0;
        for(int area : areas){
            maxArea = maxArea > area ? maxArea : area;
        }
        System.out.printf("%d\n%d", paintCount, maxArea);
    }
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int dfs(int x, int y, int area) {
        visited[x][y] = true;
        area++;
        for(int i=0; i<4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(row <0 || col<0 || row >= graph.length || col >= graph[i].length){
                continue;
            }
            if(graph[row][col] == 1 && !visited[row][col]){
                area = dfs(row,col,area);
            }
        }
        return area;
    }
}