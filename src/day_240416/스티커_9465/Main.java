package day_240416.스티커_9465;
/**
 * 상하좌우 중복 X
 * 최댓값
 * 
 * 
 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n];
            int[][] memo = new int[2][n];
            boolean[][] check = new boolean[2][n];
            StringTokenizer st;

            int[] dx = {-1,0,1,0};
            int[] dy = {0,-1,0,1};
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++){
                
            }
        }
    }
}
