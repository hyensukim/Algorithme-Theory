package day_240415.A와B2_12919;
/**
 * 16416 KB
 * 144ms
 * 
 * 문자열 뒤에 A 추가
 * 문자열 뒤에 B 추가 + 뒤집기
 * 
 * 글자수 넘었거나 문자열 동일 시 탈출
 * 재귀 기준
 * - A 추가
 * - B 추가
 */
import java.io.*;
public class Main {
    static int result = 0;
    static String S,T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        br.close();

        findAB(S);

        System.out.println(result);
    }

    static void findAB(String s){
        if(s.length() >= T.length()){
            if(s.equals(T)){
                result = 1;
            }
            return;
        }
        // 💡 현재 문자열 or 역이 T에 포함되는 지 여부를 확인하면 시간 단축 가능
        else if(!T.contains(s) && !T.contains(new StringBuilder(s).reverse().toString())) {
            return;
        }

        findAB(new StringBuilder(s + 'A').toString());
        findAB(new StringBuilder(s + 'B').reverse().toString());
    }
}