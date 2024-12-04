package day_240405.에이티엠_1399;

import java.io.*;
import java.util.*;

/**
 * 14544KB
 * 140ms
 * 25분
 * O(NlogN)
 * 
 * 1. 문제 파악
 * 줄은 1~N(순서 i, 걸린시간 Pi) 입니다.
 * 해당 i번째 사람이 인출 시걸리는 시간은 Pi의 누적합입니다.
 * 돈을 인출하는데 걸리는 시간의 합의 최솟값을 구하라는 문제입니다.
 * 
 * N : 1~1000, Pi : 1~1000
 * 
 * 2. 접근 방법
 * PriorityQueue 상에 오름차순으로 담아서 i번째까지 걸린 시간Pi를 구해줍니다. O(logN)
 * 각 걸린시간을 sum이라는 결과에 합쳐줍니다.
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine()); // 줄 갯수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        long sum = 0;
        long sub_sum = 0;
        while(!pq.isEmpty()){
            sub_sum +=pq.poll();
            sum += sub_sum;
        }

        br.close();

        System.out.println(sum);
    }
}