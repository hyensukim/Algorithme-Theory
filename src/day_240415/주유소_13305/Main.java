package day_240415.주유소_13305;
/**
 * 35916 KB
 * 400 ms
 * 
 * N : 2~100,000
 * 총 거리 : 1~10억
 * 리터당 가격 : 1~10억
 * 
 * 현재 주유가격과 이전 주유가격을 비교하는 것이 포인트
 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n-1];
        long[] fare = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            fare[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long f = fare[0];
        for(int i=0; i<n-1; i++){
            f = f > fare[i] ? fare[i] : f;
            sum += (f * dist[i]);
        }

        br.close();

        System.out.println(sum);
    }
}
