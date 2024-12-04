package day_240413.가장긴감소하는부분수열_11722;
import java.io.*;
import java.util.*;
/**
 * 14484KB
 * 152ms
 * 메모이제이션을 활용한 dp 문제
 * 
 * 1. 가장 긴 감소하는 부분 수열을 구하는 문제
 * 2. 접근 방법
 * - 현재 idx 기준 지나간 수열에 큰 값이 있는지 여부를 확인합니다.
 * - 큰 값을 발견 시 해당 값과 현재 idx 값이 감소하는 부분 수열이므로, 메모이제이션에 기록합니다.
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1]; // 입력 배열
        int[] memo = new int[n+1]; // 메모이제이션

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 10 30 10 20 20 10
        int result = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            memo[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j] > arr[i]){
                    memo[i]=Math.max(memo[i],memo[j]+1);// 1 1 2 2 2 3
                }
            }
            result = Math.max(result,memo[i]);
        }

        br.close();
        System.out.println(result);
    }
}
