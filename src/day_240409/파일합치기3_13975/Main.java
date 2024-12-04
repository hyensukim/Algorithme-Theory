package day_240409.파일합치기3_13975;

import java.io.*;
import java.util.*;
/**
 * 267608KB
 * 3156ms
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0){
            int k = Integer.parseInt(br.readLine());
            long result = 0;

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<k; i++){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while(pq.size() >= 2){
                long add = pq.poll() + pq.poll();
                result += (add);
                pq.offer(add);
            }

            sb.append(result).append("\n");

            pq.clear();
        }

        br.close();

        System.out.println(sb);
    }
}
