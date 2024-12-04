package day_240406.통계학_2108;
import java.io.*;
import java.util.*;
/**
 * 64260KB
 * 644ms
 * 40분
 * 정렬 시간 복잡도 : O(nlogn)
 * 
 * 1, 문제 파악
 * N을 대표하는 통계학적인 값(단, N은 홀수)
 * 산술평균 : N개의 수들의 합을 N으로 나눈값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타내는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * 
 * N개의 수가 주어졌을 떄, 네 가지 기본 통계값을 구하는 프로그램 작성.
 * 
 * N : 1~50만(N은 홀수)
 * 정수의 절대값들은 4천을 넘기지 않습니다.
 * 
 * 산술평균 - 소수점 이하 첫째자리에서 반올림
 * 중앙값 - 
 * 최빈값 - 여러 개 중 두 번째로 작은 값 출력
 * 범위 출력 -
 * 
 * 2. 접근 방법
 * 산술평균 - 배열을 담으면서, sum 구하고, double로 형변환 및 나눈값을 첫째 자리까지 Math.round로 반올림하기
 * 중앙값 - 배열 정렬 후 중앙 인덱스 찾기
 * 최빈값 - 배열에 담을 때, counting 배열도 함께 카운팅, 카운팅 함수의 최댓값을 구해서, 해당 값과 일치하는 index들을 추출, index 값들을 다시 정렬하여, 1번째 값을 찾기
 * 범위 - 정렬한 배열의 맨 앞과 맨 뒤 인덱스의 값을 뽑아내서 최댓값 - 최솟값 해주기
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer,Integer> counting = new HashMap<>();
        List<Integer> li = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        // O(n)
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            counting.put(num,counting.getOrDefault(num, 0)+1);
        }

        // O(nlogn)
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        // 최빈값 연산
        for(Map.Entry<Integer,Integer> entry : counting.entrySet()){
            max = Math.max(max,entry.getValue());
        }

        for(Map.Entry<Integer,Integer> entry : counting.entrySet()){
            if(max == entry.getValue()){
                li.add(entry.getKey());
            }
        }

        // O(nlogn)
        Collections.sort(li);

        // 산술평균
        sb.append(Math.round((float)sum/n)).append("\n");
        // 중앙값
        sb.append(arr[n/2]).append("\n");
        // 최빈값
        if(li.size() > 1) sb.append(li.get(1)).append("\n");    
        else sb.append(li.get(0)).append("\n");
        // 범위
        sb.append(arr[n-1]-arr[0]).append("\n");
        
        br.close();

        System.out.println(sb);
    }
}
