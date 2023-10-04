package BAEKJOON;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        /*
        영식(Y) - 30초당 10원
        민식(M) - 60초당 15원
        */
        int fee1 = 0, fee2 = 0;
        String str = "";
        while(N-- > 0){
            int time = Integer.parseInt(st.nextToken());
            
            fee1 += 10 * ((time / 30) + 1); // Y
            fee2 += 15 * ((time / 60) + 1); // M
        }
        
        if(fee1 < fee2){
            str = "Y " + fee1;
        }else{
            str = "M " + fee2;
        }
        
        if(fee1 == fee2){
            str = "Y M " + fee1;
        }
        
        System.out.println(str);
        br.close();
    }
}