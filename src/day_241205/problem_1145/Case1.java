package day_241205.problem_1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀함수로 브루트포스 간단한 문제 풀이 만들기
 */
public class Case1 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bruteForce(1, 0));

    }

    static int bruteForce(int num, int count){
        for(int i=0; i<arr.length; i++){
            if(num % arr[i] == 0){
                count++;
            }
        }
        if(count >= 3){
            return num;
        }
        return bruteForce(++num, 0);
    }
}
