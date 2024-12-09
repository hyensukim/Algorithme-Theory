package day_241209.problem_1173;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        if(M - m < T){
            System.out.println(-1);
            return;
        }
        
        int result = 0;
        int now = m;
        while(N != 0){
            if(now + T > M){
                if(now - R < m){
                    now = m;
                }else{
                    now -= R;
                }
            }else{
                now += T;
                N--;
            }
            result++;
        }
        System.out.println(result);
    }
}