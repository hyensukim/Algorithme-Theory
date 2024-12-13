package day_241213.problem_1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1225번 문제(브론즈2)
 * 메모리 : 14300KB
 * 속도 : 104ms
 * 주석 : 결국, 두 문자열의 합을 곱해주는 결과와 동일하기 때문에 해당 내용처럼 구현 시 다음과 같이 이중 for문을 사용하지 않아 빠르게 연산이 가능함.
 */
public class Case {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        long sum1 = 0;
        long sum2 = 0;

        for(char c : s1.toCharArray()){
            sum1 += c - '0';
        }

        for(char c : s2.toCharArray()){
            sum2 += c - '0';
        }
        
        long result = sum1 * sum2;
        System.out.println(result);
    }
}
