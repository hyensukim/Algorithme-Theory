package day_240410.리모컨_1107;
import java.io.*;
import java.util.*;
/**
 * 309144KB
 * 1524ms
 * 
 * 1. 문제 파악
 * 리모컨 구성 : 0~9, +(now+1), -(now-1), 채널0 - => 채널이 변하지 X
 * 리모컨 일부 버튼 고장
 * 수빈이가 이동할 채널 N
 * N으로 가기 위해 최소 몇 번 눌러야 하는지
 * 현재 100
 * 
 * 수빈이가 이동하려는 채널 N (0~50만), 고장난 버튼 갯수(0~10), 고장난 버튼, 버튼 중복 x
 * 채널 N으로 이동하기 위해 버튼을 눌러야하는 최소 횟수
 * 
 * 2. 접근 방법
 * 완전탐색법
 * 0~999,999 까지의모든 경우의 수를 탐색.
 * 해당 범위 중 최솟값을 출력합니다.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String n = br.readLine();
        int channel = Integer.parseInt(n); // 목적지 채널

        boolean[] disorder = new boolean[10]; // 고장 여부 확인 배열
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼
        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                disorder[Integer.parseInt(st.nextToken())] = true;
            }
        }
        else{
            System.out.println(n.length());
            return;
        }

        int result = Math.abs(channel-100);

        if(result == 0) {
            System.out.println(0);
            return;
        }

        // 완전 탐색
        Outer:
        for(int i=999_999; i>=0; i--){
            String value = String.valueOf(i);

            for(String v : value.split("")){
                int idx = Integer.parseInt(v);
                if(disorder[idx]){
                    continue Outer;
                }
            }
            
            int tmp = Math.abs(channel-i) + value.length();
            result = Math.min(result,tmp);
        }

        br.close();

        System.out.println(result);
    }   
}
