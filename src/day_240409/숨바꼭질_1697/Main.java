package day_240409.숨바꼭질_1697;
import java.io.*;
import java.util.*;
/**
 * 18392KB
 * 156ms
 */
public class Main {
    static Queue<Integer> q;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[100_001];

        bfs(n, k);

        br.close();
    }

    static void bfs(int start, int end){
        q = new LinkedList<>();
        q.offer(start);
        arr[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == end){ 
                System.out.println(arr[now]-1);
                return; 
            }

            int min = now - 1;
            int add = now + 1;
            int mul = now * 2;

            if(min >= 0 && arr[min] == 0){
                arr[min] = arr[now] + 1;
                q.offer(min);
            }
            
            if(add <= 100_000 && arr[add] == 0){
                arr[add] = arr[now] + 1;
                q.offer(add);
            }

            if(mul <= 100_000 && arr[mul] == 0){
                arr[mul] = arr[now] + 1;
                q.offer(mul);
            }

        }
    }
}