package day_240405.좌표압축_18870;

import java.io.*;
import java.util.*;

/**
 * 238112 kb
 * 1708ms
 * 30min
 * 1. 문제 파악
 * 좌표 압축은 입력 값 중 Xi의 값보다 작은 값의 갯수입니다.
 * 즉, 2 4 4 -> 0 1 1 이렇게 변환됩니다.
 * 
 * 2. 접근 방법
 * 기존의 index를 유지하기 위해 arr 배열 선언.
 * 1씩 증가시키면서 값을 map에 저장하기 위한 정렬할 배열 sorted 정의
 * map을 통해 key - 기존좌표(origin), value - 압축좌표(compact)
 *
 */
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i < arr.length; i++){
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sorted);
        int compact = 0;
        for(int origin : sorted){
            if(!map.containsKey(origin)){
                map.put(origin,compact++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k : arr){
            int c = map.get(k);
            sb.append(c).append(" ");
        }
        
        System.out.println(sb);
        br.close();
    }
}
