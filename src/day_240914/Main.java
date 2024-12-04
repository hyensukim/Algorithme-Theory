package day_240914;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        int n = Integer.parseInt(in.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        while(n-- > 0) {
            String input = in.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            String command = st.nextToken();
            
            if(("pop".equals(command) || "top".equals(command)) 
               && deq.size() < 1) {
                out.append(-1).append("\n");
                continue;
            }
            
            switch(command) {
                case "pop" : 
                    out.append(deq.pop()).append("\n");
                    break;
                case "size" :
                    out.append(deq.size()).append("\n");
                    break;
                case "empty" :
                    if(deq.size() < 1) {
                        out.append(1).append("\n");
                    } else {
                        out.append(0).append("\n");
                    }
                    break;
                case "top" :
                    out.append(deq.peek()).append("\n");
                    break;
                default :
                    int i = Integer.parseInt(st.nextToken());
                    deq.push(i);
                    break;
            }
        }
        
        in.close();
        
        System.out.println(out);
    }
}
