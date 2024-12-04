package day_240922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Case2 {
    
    public static long sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        int top = -1;
        sum = 0;
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            while(top > -1) {
                if(stack[top] <= now) {
                    top--;
                } else {
                    break;
                }
            }
            sum += (top + 1);
            stack[++top] = now;
        }

        System.out.println(sum);
        br.close();
    }
}
