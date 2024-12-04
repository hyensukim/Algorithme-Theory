package day_240413.동전1_2293;
import java.io.*;
import java.util.*;
/**
 * 14188KB
 * 140ms
 * 
 * 1. 문제파악
 * - n개의 동전, 가치는 다르다.
 * - 가치의 합이 k원이 되도록 하고 싶은 경우의 수.
 * - 순서 보장 X
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] memo = new int[k+1];

        for(int i=0; i<n; i++){ // 1 2 5
            coins[i] = Integer.parseInt(br.readLine());
        }

        memo[0] = 1; // 아무런 동전을 사용하지 않는 경우의 수
        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){
                if(j >= coins[i]){
                    memo[j] += memo[j - coins[i]];
                }
            }
        }

        br.close();
        System.out.println(memo[k]);
    }
}
