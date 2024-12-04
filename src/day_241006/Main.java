package day_241006;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new ArrayDeque<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int size = queue.size();
            switch(command) {
                case "push" :
                    int value = Integer.parseInt(st.nextToken());
                    queue.offer(value); break;
                case "pop" :
                    if(size > 0) {
                        sb.append(queue.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                case "size" :
                    sb.append(size).append("\n"); break;
                case "empty" :
                    if(size > 0) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(1).append("\n");
                    } break;
                case "front" :
                    if(size > 0) {
                        sb.append(queue.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                default :
                    if(size > 0) {
                        sb.append(queue.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
            }
        }
        br.close();
        System.out.println(sb);
    }
}