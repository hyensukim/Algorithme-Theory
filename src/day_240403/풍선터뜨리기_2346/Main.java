package src.day_240403.풍선터뜨리기_2346;

import java.util.*;
import java.io.*;

/**
 * 15920KB
 * 180ms
 * 60분 초과, 다른 풀이 참고
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 * --------------------------------------------------
 * 덱(Deque) 자료구조를 사용했습니다.
 * 풍선마다 인덱스와 이동횟수 상태값을 갖도록 int[]에 담았습니다.
 * 덱이 풍선을 담고, 이동 횟수의 음/양수로 분기를 나눠 풍선터뜨리기를 구현합니다.
 * 덱이 비면, 풍선이 없으므로 루프를 빠져나옵니다.
 * --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<int[]> deq = new ArrayDeque<>(); // 0 : 위치값, 1: 이동횟수

        int n = Integer.parseInt(br.readLine()); // 풍선 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            deq.offer(new int[] { i + 1, number });
        }

        // 첫번째로 터뜨리는 풍선은 무조건 1 순서의 풍선입니다.
        // 이동횟수(moveValue)의 음/양수를 확인해가며, 풍선을 터뜨립니다.
        // - 양수 : 앞에 있는 요소를 덱의 뒤로 보냅니다. *덱의 맨앞의 풍선을 터뜨립니다.
        // - 음수 : 뒤에 있는 요소를 덱의 앞으로 보냅니다. *덱의 맨뒤의 풍선을 터뜨립니다.
        sb.append("1 ");
        int moveValue = deq.pollFirst()[1];
        while (!deq.isEmpty()) {
            if (moveValue > 0) {
                for (int i = 1; i < moveValue; i++) {
                    deq.offerLast(deq.pollFirst());
                }
                int[] balloon = deq.pollFirst();
                moveValue = balloon[1];
                sb.append(balloon[0]).append(" ");
            } else {
                for (int i = 1; i < -moveValue; i++) {
                    deq.offerFirst(deq.pollLast());
                }
                int[] balloon = deq.pollLast();
                moveValue = balloon[1];
                sb.append(balloon[0]).append(" ");
            }
        }

        br.close();

        System.out.println(sb);
    }
}