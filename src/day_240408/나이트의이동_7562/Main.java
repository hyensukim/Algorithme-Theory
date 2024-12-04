package day_240408.나이트의이동_7562;
import java.io.*;
import java.util.*;
/**
 * 
 * 73124KB
 * 308ms
 * O(n)
 * 
 * 1. 문제 파악
 * 나이트가 이동할 수 있는 범위 -> 1칸(위아래좌우) + 진행 방향으로 대각선 한칸
 * 체스판 - 정사각형, 한변의 길이(I : 4~300), 현재 나이트의 칸, 나이트가 이동하려는 칸
 * 
 * 각 테스트 케이스마다 나이트가 해당 위치로 이동하기 위한 최소이동횟수를 구하시오.
 * 
 * 2. 접근 방법
 * 최소 거리 - BFS
 * BFS 핵심 로직
 * - 큐
 * - 방문 배열
 * - 인접 리스트
 * 
 * 델타배열 - 나이트 이동 방향
 */
public class Main {
    static int[] dr = {-2,-2,-1,1,2,2,-1,1};
    static int[] dc = {-1,1,2,2,-1,1,-2,-2};
    static int[][] chess;
    static boolean[][] visited;
    static Queue<Coordinate> q;
    static int l, result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-- > 0){
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            Coordinate start = new Coordinate(startRow, startCol);

            st=new StringTokenizer(br.readLine());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            Coordinate end = new Coordinate(endRow, endCol);

            if(startRow == endRow && startCol == endCol){
                sb.append(0 + "\n");
                continue;
            }

            bfs(start,end);

            sb.append(chess[endRow][endCol]).append("\n");
        }
        br.close();

        System.out.println(sb);
    }

    static void bfs(Coordinate start, Coordinate end){
        q = new LinkedList<>();
        q.offer(start);
        visited[start.row][start.col] = true;

        while(!q.isEmpty()){
            Coordinate now = q.poll();         

            if(now.row == end.row && now.col == end.col){
                return;
            }

            for(int i=0; i<8; i++){
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];

                if(nr <0 || nc < 0 || nr >= l || nc >= l) continue;

                if(visited[nr][nc]) continue;
            
                visited[nr][nc] = true;
                chess[nr][nc] = chess[now.row][now.col]+1;      
                q.offer(new Coordinate(nr, nc));
            }
        }
    }

    static class Coordinate{
        int row;
        int col;

        Coordinate(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
