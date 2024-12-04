package day_240925;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        Arrays.fill(arr,-1);
        
        NGE[] stack = new NGE[N];
        int top = -1;
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(top > -1) {
                if(stack[top].value < now) {
                    arr[stack[top].idx] = now;
                    top--;
                }else {
                    break;
                }
            }
            stack[++top] = new NGE(i,now);
        }
        br.close();
        for(int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}

class NGE {
    
    public int idx;
    public int value;
    public NGE(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}