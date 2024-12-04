package day_240922;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        for(int i=0; i<N; i++) {
            stack[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0; i<N; i++) {
            int idx = i + 1;
            while(idx<N && stack[i]>=stack[idx]) {
                sum++;
                idx++;
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}
