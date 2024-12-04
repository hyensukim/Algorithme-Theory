package day_240928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Case1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Height[] stack = new Height[N];
        long answer = 0;
        int top = -1;
        for (int i = 0; i < N; ++i) {
            int now = Integer.parseInt(br.readLine());
            Height next = new Height(now, 1);
            while (top > -1) {
                if(stack[top].height <= next.height) {
                    answer += stack[top].cnt;
                    if (stack[top].height == next.height) {
                        next.cnt += stack[top].cnt;
                    }
                    top--;
                }else {
                    break;
                }
            }
            if(top > -1){
                answer++;
            }
            stack[++top] = next;
        }
        System.out.print(answer);
    }
}

class Height
{
    public int height;
    public int cnt;

    public Height(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}