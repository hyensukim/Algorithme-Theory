package day_240527.카드역배치_10804;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[21];
        for(int i=1; i<=20; i++){
            arr[i] = i;
        }

        StringTokenizer st;
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            switchArr(start,end);
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=20; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    // idea : 배열을 반으로 나눠서 서로 바꿔준다..!
    static void switchArr(int start, int end){
        for(int i=0; i<(end-start+1)/2; i++){
            int tmp = arr[start+i];
            arr[start+i] = arr[end-i];
            arr[end-i] = tmp;
        }
    }
}