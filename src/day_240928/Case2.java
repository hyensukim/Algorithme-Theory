package day_240928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Case2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Height[] stack = new Height[N];
        long res = 0;
        int top = -1;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            int count = 1;
            while (top > -1 && stack[top].value <= now) {
                if (stack[top].value == now) {
                    count += stack[top].count;
                }
                res += stack[top--].count;
            }
            if (top > -1) {
                res++;
            }
            stack[++top] = new Height(now, count);
        }
        System.out.println(res);
    }

    static class Height {
        int value;
        int count;

        public Height(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
