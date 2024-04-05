package src.day_240404.추월_2002;

import java.io.*;
import java.util.*;

/**
 * 
 * 14368KB
 * 136ms
 * 20분
 * O(N)
 * 
 * 1. 문제 파악
 * 추월 차량 잡기
 * 대근이 입구, 영식이 출구, 각각의 차량의 나오는 순서대로 번호 적기
 * N개 차량이 지난간 뒤, 각자의 목록을 비교하여 추월한 차량의 갯수를 구하기.
 * 
 * 2N+1개의 줄로 입력, N : 1~1,000
 * 차량번호 6~8자, 영대문자 + 숫자, 번호 중복 X
 * 
 * 추월 차량 갯수 구하기
 * 
 * 2. 접근 방법
 * 큐에 입구 순서대로 담는다.
 * 큐의 peek값으로 현재 나온값이 같은지 확인한다.
 * 같으면, poll 해준다.
 * 다르면, 추월 카운팅 +1, 해당 차량을 큐에서 제거해준다.
 * N번 반복 - 분기가 2개로만 나뉘어 처리를 해주기때문에.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            q.offer(br.readLine());
        }

        int overTaking = 0;
        for (int i = 0; i < n; i++) {
            String tunnelIn = q.peek();
            String tunnelOut = br.readLine();

            if (tunnelIn.equals(tunnelOut)) {
                q.poll();
            } else {
                overTaking++;
                q.remove(tunnelOut);
            }
        }

        br.close();
        System.out.println(overTaking);
    }
}