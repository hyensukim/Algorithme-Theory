package day_240406.센티와마법의뿅망치_19638;
import java.io.*;
import java.util.*;
/**
 * 28484 KB
 * 420ms
 * 60분
 * O(nlogn)
 * 
 * 1. 문제 파악
 * 뿅망치 맞으면 - 키/2, 키가 1인 경우는 상관 X
 * 망치 사용 횟수 제한, 가장 큰 거인을 때리기 전략
 * 
 * 센티를 제외한 거읜의 나라 인구수(1~10^5), 센티의 키 (1~2*10^9), 뿅망치 횟수 (1~10^5)
 * 거인의 키 H(1~2*10^9)
 * 
 * 모든 거인이 센티보다 작으면, YES, + 뿅망치 사용 최소 횟수
 * 
 * 전 횟수를 사용했는데도 센티보다 큰 거인이 있다, NO + 가장 큰 거인의 키
 * 
 * 2. 접근 방법
 * 우선 순위 큐에 내림차순으로 담습니다.
 * 1인 경우, 뿅망치를 사용하지 않습니다.
 * 센티의 키보다 거인의 키가 크거나 같은 경우, 거인의 키 /2 해줍니다.
 * 결과적으로 poll 한 값이 센티의 키보다 크면 NO & poll 한 값을 출력합니다.
 * 센티보다 작은 순간이 오면, YES & 현재 횟수를 담아서 출력합니다. 
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 거인의 수
        int hc = Integer.parseInt(st.nextToken()); // 센티의 키
        int t = Integer.parseInt(st.nextToken()); // 뿅횟수

        // O(nlogn)
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // O(t)
        int count = t;
        while(hc <= pq.peek() && count-- > 0){
            if(pq.peek() == 1) break;
            pq.offer(pq.poll()/2);
        }

        int h = pq.peek();
        if(h < hc){
            sb.append("YES").append("\n").append(t-count);
        }
        else{
            sb.append("NO").append("\n").append(h);
        }

        br.close();

        System.out.println(sb);
    }
}
