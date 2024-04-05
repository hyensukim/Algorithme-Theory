package src.day_240404.엔번째큰수_2075;

import java.io.*;
import java.util.*;

/**
 * 
 * 275044KB
 * 864ms
 * 20min
 * 
 * 1. 문제 파악
 * N^2의 표에서 각 항목을 비교하여 N번째 큰 수를 출력.
 * 
 * 2. 접근 방법
 * PriorityQueue를 사용하여 접근하면 간단하게 구현이 가능.
 * PriorityQueue가 빠른이유?
 * https://velog.io/@jaeyunn_15/DataStructure-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90-Priority-Queue
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < n; i++) {
            pq.poll();
        }

        br.close();
        System.out.println(pq.peek());
    }
}
