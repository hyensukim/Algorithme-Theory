package day_240819;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int flagS = 0;
        int flagE = n-1;
        int count = 0;
        while(flagS < flagE){
            long sum = nums[flagS] + nums[flagE];
            if (x == sum){
                count++;
            }
            flagS++;
            flagE--;
        }
        
        System.out.println(count);
        br.close();
    }
}