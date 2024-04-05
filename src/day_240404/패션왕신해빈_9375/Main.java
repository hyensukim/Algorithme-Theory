package src.day_240404.패션왕신해빈_9375;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 정리
 * 매일 다른 코드로 입는다.(중복 X) ex) 안경 -코트 -상의, 다음날 안경 -코트-상의-바지
 * 케이스 100개
 * n 0~30, 의상과 종류가 공백으로 주어진다.
 * 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1~20, 소문자, 동일명의 의상 X
 * 알몸이면 안된다.
 * 
 * 2. 접근방법
 * 동일 종류끼리 중복 X - 하나의 종류에 하나만 선택
 * map으로 종류를 key로 갖고 갯수를 value로 지정하여, 종류의 갯수를 구하기
 * 각 종류별 경우의 수를 구하여 곱해줌으로써 경우의 수끼리의 경우의 수를 구함.
 * 결과를 출력.
 * 
 * 3. 주의할 점
 * 해당 종류를 안입는다는 것을 고려해야 한다.(경우의 수 + 1씩)
 * 알몸일 떄는 제외한다. 즉, 하나의 경우의 수를 배제한다.(전체 경우의 수 -1)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken(); // 이름 사용 X
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int totalCount = 1;

            for (int value : map.values()) {
                totalCount *= (value + 1); // 착용하지 않는 경우의 수 +1
            }

            sb.append(totalCount - 1).append("\n"); // 알몸인 경우의 수 배제

            map.clear();
        }

        br.close();

        System.out.println(sb);
    }
}