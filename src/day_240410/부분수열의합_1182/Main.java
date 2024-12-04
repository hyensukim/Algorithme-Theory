package day_240410.부분수열의합_1182;
import java.util.*;
import java.io.*;
 /**
  * 1. 문제 파악
  * N개의 정수로 구성된 수열
  * 수열 중 부분 수열의 원소 합이 S가 되는 경우의 수를 구하시오.
  * 
  * 입력 
  * N : 1~20, S : -100만 ~ 100만
  * 
  * 출력
  * 합이 S가 되는 부분수열의 갯수를 출력합니다.
  * 
  * 2. 접근 방법
  * 백트래킹 - dfs를 활용하여 구현.
  * 수열의 부분을 더해준 뒤 합을 S 값과 비교해줍니다.
  * 같은 경우, counting
  * 다른 경우, backtracking하여, 복구
  */

public class Main {
    static int[] arr;
    static int target, result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        
        br.close();

        System.out.println(result);
    }

    static void dfs(int sum, int idx){
        if(idx >= arr.length) return;

        if(sum + arr[idx] == target) result++;
        
        dfs(sum + arr[idx],idx+1);
        dfs(sum,idx+1);
    }
}

// public class Main {
//     static boolean[] visited;
//     static int[] arr;
//     static int result;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int s = Integer.parseInt(st.nextToken());

//         arr = new int[n];
//         visited = new boolean[n];

//         st = new StringTokenizer(br.readLine());
//         for(int i=0; i<n; i++){
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         for(int i=0; i<n; i++){
//             visited[i] = true;
//             dfs(s,arr[i]);
//         }
        
//         br.close();

//         System.out.println(result);
//     }

//     static void dfs(int target, int sum){

//        if(sum == target){
//            result++;
//            return;
//        }

//        for(int i=0; i < arr.length; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                dfs(target,sum+arr[i]);
//                visited[i] = false;
//            }
//        }
//     }
// }