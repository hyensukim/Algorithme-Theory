package day_241213.problem_1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1225번 문제(브론즈2)
 * 메모리 : 296656KB
 * 속도 : 1512ms
 * 주석 : 단순하게 각 항을 곱한 뒤 더해주는 연산으로 구현. 이중 for문 구현으로 인해 시간 복잡도가 올라가게 됨.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        long result = 0L;
        for(int i=0; i<s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                int num1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
                int num2 = Integer.parseInt(String.valueOf(s2.charAt(j)));
                result += num1 * num2;
            }
        }

        System.out.println(result);
    }
}