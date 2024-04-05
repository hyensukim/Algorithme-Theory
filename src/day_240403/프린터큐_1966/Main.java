package src.day_240403.프린터큐_1966;

import java.io.*;
import java.util.*;

/**
 * 16680kb
 * 160ms
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 * --------------------------------------------------
 * 큐(Queue) 자료구조를 사용했습니다.
 * 현재 요소의 크기를 큐 내부에 최댓값과 비교합니다.
 * 최댓값보다 작으면 큐 뒤로 다시 offer 해주고, 아닌 경우 poll 해줍니다.
 * 찾고자 하는 요소의 인덱스가 -1이 될때까지 반복합니다.
 * --------------------------------------------------
 */

// test-case t, 문서 갯수 n, 출력할 문서 현재 위치 m, 문서 중요도 p
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 항목 갯수
            int m = Integer.parseInt(st.nextToken()); // 찾을 항목 현재 위치
            st = new StringTokenizer(br.readLine());

            if (n < 2) {
                sb.append(1).append("\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int out_count = 0, now_index = m;

            /**
             * 요소의 크기를 최댓값과 비교하여 작으면 큐에 담고, 크거나 같으면 큐에서 제거해줍니다.
             * 이때, 핵심은 큐의 맨 앞 요소는 무조건 큐에 다시 담기거나 제거된다는 점입니다.
             * 이를 통해서 찾을 요소의 index를 지속적으로 하나씩 줄여줍니다.
             */
            while (now_index >= 0) {
                int factor = q.peek();

                if (factor < Collections.max(q)) {
                    q.offer(q.poll());
                    if (now_index == 0)
                        now_index = q.size();
                } else {
                    out_count++;
                    q.poll();
                }

                now_index--;
            }

            q.clear();

            sb.append(out_count).append("\n");
        }

        br.close();

        System.out.println(sb);
    }
}