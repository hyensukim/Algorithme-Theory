package day_240913;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Case1{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++) {
            q.offer(i);
        }
        
        int k = Integer.parseInt(st.nextToken());
        while(q.size() > 1){
            
            if(q.peek() == null){
                break;
            }
            
            for(int i=0; i<k-1; i++) {
                q.offer(q.poll());
            }
            
            sb.append(q.poll());
            sb.append(", ");
        }
        br.close();
        
        sb.append(q.poll()).append(">");
        
        System.out.println(sb.toString());
    }
}
