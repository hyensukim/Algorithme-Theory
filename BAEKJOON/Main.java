package BAEKJOON;

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        long maxDiv = 0, minSup = 0;
        
        maxDiv = gcd(n1, n2);
        
        minSup = (maxDiv) * (n1/maxDiv) * (n2/maxDiv);
        
        System.out.println(maxDiv + "\n" + minSup);
    }

    private static int gcd(int p, int q){
        p = p > q ? p : q;
        q = p > q ? q : p;
        
        if(q == 0) return p;
        return gcd(q, p%q);
    }
}