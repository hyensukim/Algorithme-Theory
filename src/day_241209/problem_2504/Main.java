package day_241209.problem_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 2504번 문제(골드5)
 * 스택을 활용한 문제이지만, 활용이 필요한 문제.
 * 
 * 스택을 활용하여 언제 점수를 곱하거나 더해줘야 하는지에 대한 이해가 필요.
 * 
 * 추후 다시한번 풀이할 예정임.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;

        OUT: for(int i=0; i<in.length(); i++){
            char c = in.charAt(i);

            switch(c){
                case '(':
                stack.add('(');
                    tmp *= 2;
                    break;

                case '[':
                stack.add('[');
                    tmp *= 3;
                    break;

                case ')':
                    if(stack.isEmpty() || stack.peek()!='('){
                        result = 0;
                        break OUT;
                    }
                    else{
                        if(in.charAt(i-1)=='(')  result += tmp;
                        stack.pop();
                        tmp /= 2;
                    }
                    break;

                case ']':
                    if(stack.isEmpty() || stack.peek()!='['){
                        result = 0;
                        break OUT;
                    }
                    else{
                        if(in.charAt(i-1)=='[')  result += tmp;
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
