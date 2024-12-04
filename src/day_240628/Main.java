package day_240628;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        
        for(int i=N; i>0; i--){
            StringBuilder sb2 = new StringBuilder();
            
            for(int j=0; j<N-i; j++){
                sb2.append(" ");
            }
            
            for(int j=0; j<i-1; j++){
                sb2.append("*");
            }

            String row = sb2.toString() + "*" + sb2.reverse().toString().trim();
            sb.append(row);
            sb.append("\n");

            if(i != 1){
                stack.add(row);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
