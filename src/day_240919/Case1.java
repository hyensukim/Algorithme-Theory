package day_240919;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.ArrayDeque;

public class Case1{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new ArrayDeque<>();
        for(int i=n; i > 0; i--) {
            arr.push(i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for(int i=0; i<n; i++) {
            int v = Integer.parseInt(br.readLine());
            if(max < v) {
                int diff = v - max;
                while(diff-- > 0) {
                    stack.push(arr.pop());
                    sb.append("+").append("\n");
                }
                max = v;
            } else {
                if(stack.peek() != v) {
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
