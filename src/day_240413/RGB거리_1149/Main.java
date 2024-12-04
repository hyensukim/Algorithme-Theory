package day_240413.RGB거리_1149;
import java.io.*;
import java.util.*;
/**
 * 14672KB
 * 148ms
 * 
 * 다른 풀이 참조
 * 
 * 1. 문제 파악
 * R G B 아래조건 만족 && 모든 집을 칠하는 비용의 최솟값
 * 이웃하는 집의 색은 다르게 표시
 * 
 * 2. 접근 방법
 * - 위 이웃하지 않는 조건을 만족하는 R, G, B 의 누적합을 메모이제이션 처리
 * - 해당 값(3가지) 중 최솟값을 출력
 * 
 * 3.💡
 * 상수를 사용하여 int 값을 상수 명칭으로 표현하는 방식. - 획기적
 * 
 */
public class Main {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    static int[][] cost;
    static int[][] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        memo = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        br.close();

        memo[0][RED] = cost[0][RED];
        memo[0][GREEN] = cost[0][GREEN];
        memo[0][BLUE] = cost[0][BLUE];

        int red_stack = memoization(n-1,RED);
        int green_stack = memoization(n-1,GREEN);
        int blue_stack = memoization(n-1,BLUE);
        
        System.out.println(Math.min(red_stack, Math.min(green_stack, blue_stack)));
    }

    static int memoization(int n, int color){
        if(memo[n][color] == 0){
            if(color == RED){
                memo[n][RED] = Math.min(memoization(n-1, GREEN), memoization(n-1, BLUE)) + cost[n][RED];
            }
            else if(color == GREEN){
                memo[n][GREEN] = Math.min(memoization(n-1, RED), memoization(n-1, BLUE)) + cost[n][GREEN];
            }
            else if(color == BLUE){
                memo[n][BLUE] = Math.min(memoization(n-1, GREEN), memoization(n-1, RED)) + cost[n][BLUE];
            }
        }

        return memo[n][color];
    }
}
