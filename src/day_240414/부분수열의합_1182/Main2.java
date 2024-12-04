package day_240414.부분수열의합_1182;
/**
 * 14880 KB
 * 244 ms
 */
import java.util.*;
import java.io.*;
public class Main2 {
    static int[] arr;
    static boolean[] visited;
    static int n,s,result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            combination(0,i);
        }

        br.close();

        System.out.println(result);
    }

    static void combination(int start, int r){ // r : 조합의 갯수
        if(r == 0){
            int sum = 0;
            for(int i=0; i<n; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }

            if(sum == s){
                result++;
            }

            return;
        }

        for(int i=start; i<n; i++){
            visited[i] = true;
            combination(i+1,r-1);
            visited[i] = false;
        }
    }
}
