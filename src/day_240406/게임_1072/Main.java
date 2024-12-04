package day_240406.게임_1072;

import java.io.*;
import java.util.*;

/**
 * 14192KB
 * 128ms
 * 60분 초과, 다른 풀이 참고
 * 이분탐색 시간복잡도: O(logN)
 * 
 * 1. 문제 파악
 * 게임 횟수 : X, 이긴 게임 Y(Z%), Z는 승률(소수점 X)
 * 절대 지지않는다.
 * 게임을 최소 몇 번 더해야 Z가 변하는지 구하시오.
 * 
 * X 1~10억, Y 0~10억
 * 최소 몇 판 더해야하는지 결과 출력, 만약 Z가 변하지 않는다면 -1을 출력.
 * 
 * 2. 접근 방법
 * 이분탐색
 * max : 10억, min : 0
 * 절대 지지 않기 때문에 증가하는 경우만 따지면 됩니다.
 * 승률이 바뀌는 처음 지점을 찾아야 하기 때문에, lower bound로 구현해줍니다.
 * 해당 percent가 z보다 클 경우(같지 않을 경우), 최소값을 탐색하기 위해서, max를 줄여줍니다.
 * 같을 경우, z보다 커야되기 때문에 min을 올려줍니다.
 * 이를 반복하여, max보다 min이 커졌을 때, 해당하는 mid 값이 결과로 출력됩니다.
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = calculatePercent(x, y);

        int min = 0;
        int max = 1_000_000_000;
        int result = -1;
        while(min <= max){
            int mid = (max + min)/2;
            int win_percent = calculatePercent(x+mid, y+mid);

            if(win_percent > z){
                result = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        
        br.close();

        System.out.println(result);
    }

    static int calculatePercent(int x, int y){
        return (int)((long)y * 100 /x);
    }
}