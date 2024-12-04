package day_241204.problem_1032;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 1032번
 * 문자열, 구현
 * 14240KB
 * 104ms
 */
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        String[] files = new String[N];
        
        for(int i=0; i<N; i++){
            files[i] = in.readLine();
        }
        
        boolean[] sameArr = new boolean[files[0].length()];
        for(int i=0; i<files[0].length(); i++){
            char ch = files[0].charAt(i);
            sameArr[i] = true;
            for(int j=1; j<N; j++){
                if(ch != files[j].charAt(i)){
                    sameArr[i] = false;
                    break;
                }
            }
            
            if(sameArr[i]){
                out.append(ch);
            } else {
                out.append("?");
            }
        }
        
        System.out.println(out);
    }
}