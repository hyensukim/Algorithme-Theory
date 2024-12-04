package day_240928;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] stack = new int[N];
        int top = -1;
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(br.readLine());
            while(top > -1) {
                if(stack[top] < now) {
                    stack[top--] = now;
                    res++;
                }else {
                    res++;
                    break;
                }
            }
            stack[++top] = now;
        }
        
        br.close();
        System.out.println(res);
    }
}