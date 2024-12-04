package day_240410.외판원순회2_10971;
import java.io.*;
import java.util.*;
/**
 * 
 * 14580KB
 * 160ms
 * 
 * 1. 문제파악
 * 1~N 도시들, 도시 사이에 길 O or X, N개의 도시를 모두 거쳐서 다시 원래의 도시로 돌아오는 순회.
 * 한 번 갔던 도시로는 다시 들어갈 수 없다.(방문 여부 확인 - 맨 마지막에 원래 출발했던 도시로 돌아오는 것은 예외)
 *
 * 각 도시간에 드는 비용 행렬 W[i][j] : i -> j 가기 위한 비용.
 * 비용은 대칭적이지 않다. i->j !=  j->i
 * 
 * 모든 도시간의 비용은 양의 정수이다. i->i는 항상 0, i->j 못가면 0
 * 
 * 입력
 * n(도시 수) : 2~10, 비용 : 1~100만
 * 출력
 * 순회를 위한 최소 비용
 * 
 * 2. 접근 방법
 * dfs를 사용하여 분기마다 총 비용을 계산합니다. 
 * 계산한 비용은 기존의 min 값과 비교하여 더 작은값을 넣어줍니다.
 * 
 */
public class Main {
    static boolean[] visited;
    static int[][] fees;
    static int n, min=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        fees = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                fees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            visited[i] = true;
            dfs(i,i,0,n-1);
        }

        br.close();

        System.out.println(min);
    }

    static void dfs(int start, int now, int sum, int depth){

        if(depth == 0){
            if(fees[now][start] != 0){
                min = Math.min(min,sum + fees[now][start]);
            }
            return;
        }

        for(int i=0; i<n; i++){
            int fee = fees[now][i];
            if(fee != 0 && !visited[i]){
                visited[i] = true;
                dfs(start,i,sum + fee,depth-1);
                visited[i] = false;
            }
        }
    }
}
