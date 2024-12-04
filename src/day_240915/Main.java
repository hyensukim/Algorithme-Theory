import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        while(k-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(!deq.isEmpty() && n == 0){
                deq.pop();
            } else {
                deq.push(n);
            }
        }
        br.close();
        long sum = 0;
        while(!deq.isEmpty()) {
            sum += deq.pop();
        }
        System.out.println(sum);
    }
}