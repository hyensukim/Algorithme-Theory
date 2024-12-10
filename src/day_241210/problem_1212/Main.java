package day_241210.problem_1212;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 문제(레벨): 1212번(브론즈2)
 * 메모리: 37108KB
 * 시간: 328ms
 * 주석: 2진수 변환 후 앞에 0이라는 값을 어떻게 제거해줄까 가 키포인트
 */
public class Main{
    
    static String[] base = {"000","001", "010", "011", "100", "101", "110", "111"};
    
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();

        if(S.equals("0")){
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int firstDigit = Integer.parseInt(String.valueOf(S.charAt(0)));
        String firstBinary = base[firstDigit];
        for(int i=0; i<3; i++){
            if(firstBinary.charAt(i) == '1'){
                sb.append(firstBinary.substring(i));
                break;
            }
        }

        for(int i=1; i<S.length(); i++){
            int idx = Integer.parseInt(String.valueOf(S.charAt(i)));
            sb.append(base[idx]);
        }

        System.out.println(sb.toString());
    }
}
