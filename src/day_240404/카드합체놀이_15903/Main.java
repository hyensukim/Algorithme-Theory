package src.day_240404.카드합체놀이_15903;

import java.io.*;
import java.util.*;

/**
 * 
 * 15304KB
 * 164ms
 * O(NlogN)
 * 
 * 1. 문제파악
 * 자연수가 쓰여진 카드 n장, i번 카드에 ai =가 쓰임.
 * x와 y가 같지 않으면, x + y 계산한 값을 x와 y에 모두 덮어쓴다.
 * 합체 횟수 m,, n장의 카드에 쓰인 모든 수를 더한 값이 점수가 된다.
 * 해당 점수를 가장 작게 만드는 것이 놀이의 목표.
 * 
 * n:2 ~1,000 , m:0~만오천
 * 
 * 2. 접근방식
 * 우선순위 큐를 사용하여 오름차순 정렬해준다.
 * 2개를 poll하여 두 수가 같지 않으면, 더해서 2번 offer 해준다.
 * 두 수가 같으면, 하나를 다시 poll한 뒤 다른 두개의 값을 더해준다.
 * 더한 수와 남은 수(중복)를 다시 offer해준다.
 * m번 연산이 끝나면 큐 전체의 요소 합을 구해준다.
 * 
 * 3. 주의할점
 * Queue에 들어가는 값이 Long 타입이어야 한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Long> pq = new PriorityQueue<>();
        // List<Long> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long x = pq.poll();
            long y = pq.poll();

            pq.offer(x + y);
            pq.offer(x + y);
            // else {
            // while (x == y) {
            // list.add(x);
            // x = pq.poll();
            // }

            // for (int z : list) {
            // pq.offer(z);
            // }

            // pq.offer(x + y);
            // pq.offer(x + y);
            // }
        }

        long result = 0;
        for (long q : pq) {
            result += q;
        }

        br.close();

        System.out.println(result);
    }
}
