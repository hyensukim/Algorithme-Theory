package src.test;

import java.io.*;
import java.util.*;

public class 퀵정렬 {
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i < N; i++){
            arr[i] = (int)(Math.random()*N);//0~9
        }

        System.out.println("정렬 전 : " + Arrays.toString(arr));
        quick_sort(arr, 0, N-1);

        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }

    static void quick_sort(int[] arr, int low, int high){
        if(low >= high)
            return;

        int pivot = partition(arr,low, high);

        quick_sort(arr, low, pivot);
        quick_sort(arr, pivot+1, high);
    }

    static int partition(int[] arr, int left, int right){

        int low = left-1; // -1
        int high = right+1; // N
        int pivot = arr[(left+right)/2];

        while(true){
            while(arr[++low] < pivot);
            while(arr[--high] > pivot && high >= low);

            if(low >= high)
                return high;
            
            swap(arr,low,high);
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
