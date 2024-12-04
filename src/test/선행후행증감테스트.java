package test;

import java.io.*;
import java.util.Arrays;

public class 선행후행증감테스트 {
    public static void main(String[] args) throws IOException{
         int[] arr = new int[10];

         for(int i=0; i < 10; i++){
            arr[i] = i+1;
         }

         int[] cnt = new int[10];
         for(int i =0; i< arr.length; i++){
            cnt[i] = arr[i];
            if(arr[i] == 3){
                cnt[i] = arr[i]++;
            }
         }

         System.out.println("arr : " + Arrays.toString(arr));
         System.out.println("cnt : " + Arrays.toString(cnt));
    }

}
