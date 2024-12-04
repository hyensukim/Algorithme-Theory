package day_240405.입국심사_3079;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 파악
 * 친구들은 총 M명, 입국 심사대 N개, 심사시간은 사람마다 다름.
 * 심사 시간은 Tk, 비어있는 심사대에 무조건적으로 들어갈 필요는 없다.
 * 심사 받는데 걸리는 시간이 최소가 되는 경우를 구하시오.
 * 
 * N : 1~10만, M : 1~10억, Tk 1~10^9
 * 심사를 마치는데 걸리는 최소시간
 * 
 * 2. 접근 방법
 * 
 * 
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr= new int[n];

        int max = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]) ;
        }

        long low = 0;
        long high = max * m;
        long result = Long.MAX_VALUE;
        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;

            for(int a : arr){
                long tmp = mid/a;

                if(sum >= m) break;

                sum += tmp;
            }

            if(sum >= m){
                result = Math.min(result,mid);
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }

        br.close();

        System.out.println(result);
    }
}