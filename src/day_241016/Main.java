import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command) {
                case "push" :
                    int push = Integer.parseInt(st.nextToken());
                    que.offer(push);
                    break;
                case  "pop" :
                    if(que.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        int pop = que.poll();
                        sb.append(pop).append("\n");   
                    }
                    break;
                case "size" :
                    int size = que.size();
                    sb.append(size).append("\n");
                    break;
                case "empty" :
                    if(que.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if(que.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        int front = que.peekFirst();
                        sb.append(front).append("\n");
                    }
                    break;
                default :
                    if(que.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        int last = que.peekLast();
                        sb.append(last).append("\n");
                    }
            }
        }
        br.close();
        System.out.println(sb);
    }
}