package day_240817;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int[] resArr = new int[10];
        
        String str = a * b * c + "";
        char[] chars = str.toCharArray();
        for(char ch : chars){
            resArr[ch-48]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : resArr){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}