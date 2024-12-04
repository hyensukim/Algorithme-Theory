package day_240416.센서_2212;
/**
 * 집중국의 수신 가능 영역 - 고속도로 상에서 연결된 구간
 * N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야함.
 * 집중국 수신가능 영역의 길이합 최소화해야함
 * 수신 가능 영역의 길이 : 0~이상, 모든 센서의 좌표가 다를 필요 X
 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 센서 갯수
        int k = Integer.parseInt(br.readLine()); // 집중국 갯수

        int result = 0;
        if(n <= k) {
            System.out.println(0);
            return;
        }
        else{
            int[] sensors = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                sensors[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(sensors);

            Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<n-1; i++){
                q.offer(sensors[i+1] - sensors[i]);
            }
            
            for(int i=0; i<k-1;i++){
                q.poll();
            }

            while(!q.isEmpty()){
                result += q.poll();
            }
        }

        System.out.println(result);
    }
}