package src.day_240404.절대값힙__11286;

import java.io.*;
import java.util.*;

/**
 * 1. 문제파악
 * 배열에 정수를 담는다. x는 0이 아니다.
 * 배열에서 절대값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * 여러개인경우, 가장 작은 수 출력 후 그 값을 배열에서 제거한다.
 * 
 * 연산의 갯수 N (1~십만), 정수 x(2^-31~2^31)
 * 정수 x = 0 -> 가장 작은 값 출력 및 해당값 삭제, x != 0 -> 값을 추가
 * 
 * 2. 접근방법
 * 클래스 CustomNum 생성 - index : 절대값, origin : 부호포함수
 * 대신에 Comparator compare 재정의 - 오름차순(작은순서로 뽑아야함)
 * 0이 아니면, PQ에 담기, 갯수 카운팅을 위해 x를 HashMap 정의 및 담기.
 * 0을 만나면, PQ peek 값으로 음/양수 갯수 확인
 * - 2개 이상인 경우 음수 있으면 poll값에 -, 양수만 있으면 poll + 한 뒤 카운팅 내리기
 * - 1개 인 경우, 동일하게 부호확인하여 출력.
 * - 만약, PQ 사이즈가 0 인 경우, 0을 추가.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

    }
}
