package day_240403.탑_2493;

import java.io.*;
import java.util.*;

/**
 * 87484 KB
 * 880 ms
 * 
 * 1. 문제 파악
 * N개의 서로 다른 높이의 탑이 왼쪽부터 오른쪽 방향으로 있음.
 * 레이저는 왼쪽으로 발사, 가장 먼저 만나는 탑엠만 수신.
 * 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지 알아내라.
 * N 1~50만, H 1~1억
 * 
 * 2. 접근방법
 * * O(N^2) 보다 작은 방식으로 구현하기
 * 0. Tower 클래스 정의하기 - index, height(상태값 2개이상이면 고려하기)
 * N만큼 반복하기
 * 1. 스택에 담긴 값이 없는 경우 0담기
 * 2-1 스택에 담긴 값이 있는 경우 + peek 값이 현재값과 비교하여 크면 스택에 있는 타워의 인덱스 담기
 * 2-2 스택에 담긴 값이 있는 경우 + peek 값이 작으면, 사이즈가 0이되거나 큰값 나올때까지 pop 반복
 * 3. Tower 객체로 만들어서 스택에 담기
 */
// 60분 초과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Tower> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N만큼 반복하기
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 값이 있는데 peek가 작은 타워들 다 없애기
            while (!stack.empty() && stack.peek().height < now) {
                stack.pop();
            }

            if (stack.empty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(i + 1, now));
        }

        br.close();

        System.out.println(sb);
    }
}

class Tower {
    public int index;
    public int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder sb = new StringBuilder();

// int n = Integer.parseInt(br.readLine());
// StringTokenizer st = new StringTokenizer(br.readLine());

// ArrayList<Integer> list = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// list.add(Integer.parseInt(st.nextToken()));
// }

// for (int i = list.size() - 1; i >= 0; i--) {
// int tower_height = list.get(i);
// int communication = -1;

// for (int j = i - 1; j >= 0; j--) {
// if (tower_height <= list.get(j)) {
// communication = j + 1;
// break;
// }
// }

// if (communication == -1) {
// sb.append(0).append(" ");
// } else {
// sb.append(communication).append(" ");
// }
// }

// br.close();

// System.out.println(sb.reverse().toString().trim());
// }
// }
