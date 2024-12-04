package day_240822;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] students = new int[2][7];
        
        while(n-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            students[sex][grade]++;
        }
        br.close();
        
        long totalRoom = 0;
        for(int i=0; i<students.length; i++){
            for(int j=1; j<students[i].length; j++){
                int count = students[i][j];
                if(count == 0){
                    continue;
                } else if (count <= k) {
                    totalRoom++;
                } else {
                    totalRoom += (long)(Math.ceil(count / (double)k));
                }
            }
        }
        System.out.println(totalRoom);
    }
}