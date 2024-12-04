package day_240409.스카이라인쉬운거_1863;
import java.io.*;
import java.util.*;
/**
 * 20732KB
 * 216ms
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        stack.push(0);
        while(n-- >0){
            int y = Integer.parseInt(br.readLine().split(" ")[1]);
            while( stack.peek() > y){
                stack.pop();
                count++;
            }
            
            if(stack.peek() == y) continue;
            
            stack.push(y);
        }

        while(!stack.isEmpty()){
            if(stack.peek() > 0){
                count++;
            }
            stack.pop();
        }

        br.close();

        System.out.println(count);
    }
}

