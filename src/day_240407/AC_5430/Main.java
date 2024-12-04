package day_240407.AC_5430;
import java.io.*;
import java.util.*;
/**
 * 1. 문제 파악
 * AC 언어 - 뒤집기(R) - 배열의 순서를 뒤집기, 버리기(D) - 첫번째 수 버리기
 * 테스트 케이스(T) - 1~100
 * 수행할 함수 p - 1~10만
 * 배열에 담긴 갯수 n - 0~10만
 * 배열에 담긴 정수 xi - 1~100
 * p의 길이의 합과 n의 합은 70만을 넘기지 않음
 * 
 * 각 테스트 케이스에 대해서 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력합니다. 만약, 에러 발생 시 error 출력
 * 
 * 2. 접근 방법
 * R - 양방향으로 삭제가 가능하도록 Deque(덱)으로 구현하고, R 발생 시 이를 하나의 boolean 변수에 정방향(true) 또는 역방향(false)인지 상태값으로 관리하도록 구현했습니다.
 * D - 정방향과 역방향 여부와 덱이 비었는지 여부를 확인 후, 정방향이라면 pollFirst, 역방향이라면 pollLast를 수행해줍니다.
 *   - 비어있다면, error를 StringBuilder에 담습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0){
            String commands = br.readLine(); // R과 D의 조합
            int n = Integer.parseInt(br.readLine()); // 배열 갯수
            st = new StringTokenizer(br.readLine(),"[],");
            
            for(int i=0; i<n; i++){
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true; // 정방향 - t, 역방향 - f
            boolean isError = false;
            for(String command : commands.split("")){
                if("R".equals(command)){
                    flag = !flag;
                    continue;
                }
            
                if(flag){

                    if(dq.pollFirst() == null){
                        isError = true;
                        sb.append("error\n");
                        break;
                    }

                }
                else{
                    if(dq.pollLast() == null){
                        isError = true;
                        sb.append("error\n");
                        break;
                    }
                }
            }

            if(!isError){
                sb.append("[");
                if(dq.size() > 0){
                    if(flag){
                        sb.append(dq.pollFirst());
                        while(!dq.isEmpty()){
                            sb.append(",").append(dq.pollFirst());
                        }

                    }
                    else{
                        sb.append(dq.pollLast());
                        while(!dq.isEmpty()){
                            sb.append(",").append(dq.pollLast());
                        }
                    }
                }
                sb.append("]\n");
            }
        }

        br.close();

        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
