package src;

import java.util.*;
import java.io.*;

/**
 * VPS : 열림 괄호("(")와 닫힘 괄호(")")의 갯수를 똑같이 만든 괄호 문자를 의미합니다.
 * Stack 자료 구조를 이용하여 접근합니다.
 * 열림 괄호가 오면 Stack에 담습니다.
 * 닫힘 괄호가 오면 Stack에서 빼줍니다.
 * - Stack에 값이 있는지 확인, 위에 담긴 요소가 열림 괄호인지 확인 후 빼줍니다.
 * - 아닌 경우, Stack에 담습니다.
 * Stack에 남은 요소가 있는지 없는지에 따라 출력문을 결정합니다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>(); // 괄호 담을 Stack

        for (int i = 0; i < t; i++) { // 테스트 케이스만큼 돌리기
            String line = br.readLine();

            for (String l : line.split("")) {// 문자열 한자씩 나누기
                if ("(".equals(l)) { // 열림 괄호니?
                    stack.push(l);
                } else { // 닫힘 괄호니?
                    if (!stack.empty() && "(".equals(stack.peek())) { // 남은 요소가 있니?
                        stack.pop();
                    } else { // 요소가 없으면 추가
                        stack.push(l);
                        break;
                    }
                }
            }

            if (stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

            stack.clear();
        }

        br.close();

        System.out.println(sb);
    }
}