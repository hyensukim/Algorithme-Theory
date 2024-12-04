package day_240818;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] nums = new int[10];
        
        for(char ch : chars) {
            nums[ch-48]++;
        }
        
        int res = 1;
        for(int i = 0; i < 9; i++){
            if(res < nums[i]){
                if(i == 6){
                    res = (int)Math.ceil((nums[6] + nums[9]) / 2F);
                } else {
                    res = nums[i];
                }
            }
        }
        
        System.out.println(res);
        br.close();
    }
}