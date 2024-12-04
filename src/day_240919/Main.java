package day_240919;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(in.readLine());
        int[] stack = new int[n+1];
        int idx = 0;
        int s = 0;

        while(n-- > 0) {
            int v = Integer.parseInt(in.readLine());
            if(s < v) {
                for(int i=s+1; i<=v; i++) {
                    stack[++idx] = i;
                    sb.append('+').append('\n');
                }
                s = v;
            } else if(stack[idx] != v) {
                System.out.println("NO");
                return;
            }
            idx--;
            sb.append('-').append('\n');
        }
        in.close();
        System.out.println(sb);
    }
}

