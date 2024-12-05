package day_241205.problem_1145;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1145번 문제
 * 브루트포스(단순한힘): 단순히 모든 경우의 수를 검증하는 것을 통해서 탐색하는 완전 탐색법
 * 예를 들어, 4자리 자연수 중 비밀번호를 맞추라고 할 때, 1111 ~ 9999 까지의 모든 조합을 입력해보는 것과 같다.
 * 
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1 ;
        while(true){ // while loop를 활용한 방법
            int count = 0;
            for(int i=0; i<arr.length; i++){
                if(result % arr[i] == 0){
                    count++;
                }
            }
            if(count >= 3){
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}