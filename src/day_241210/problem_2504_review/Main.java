package day_241210.problem_2504_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제: 2504번(골드5)
 * 메모리: 14264KB
 * 시간: 108ms
 * 주석:
 *  - 라벨을 통한 for문 탈출 구현
 *  - 올바른 괄호열 여부 판단을 위한 처리
 *   - 반환 시, result 0으로 초기화 → []] 와 같은 케이스는 stack도 비어있지만, result가 0이 아니므로 초기화 필요
 *   - (()]) 와 같은 케이스는 stack이 비어있는지 여부를 통해 판별 가능
 *  - '(' 또는 '[' 이 나올 때마다 임시값(tmp)에 곱해준 다음, 필요 없게 되면 나눠주는 식으로 구현
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int result = 0;
        int tmp = 1;

        OUT : for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            switch(ch){
                case '(' :
                    stack.push('(');
                    tmp *= 2;
                    break;
                case '[' :
                    stack.push('[');
                    tmp *= 3;
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.peek() != '('){
                        result = 0;
                        break OUT;
                    }else{
                        if(str.charAt(i-1) == '(') result += tmp;
                        stack.pop();
                        tmp /= 2;
                    }
                    break;
                case ']' :
                    if(stack.isEmpty() || stack.peek() != '['){
                        result = 0;
                        break OUT;
                    }else{
                        if(str.charAt(i-1) == '[') result += tmp;
                        stack.pop();
                        tmp /= 3;
                    }
                    break;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
