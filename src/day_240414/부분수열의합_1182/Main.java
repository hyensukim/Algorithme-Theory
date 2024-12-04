package day_240414.부분수열의합_1182;
import java.io.*;
import java.util.*;

/**
 * Main
 */
/**
 * 14904KB|244ms
 * 백트래킹 사용해서 풀었음
 * 조합을 구하면서 만약 그 조합의 원소 합이 s와 같으면 카운트
 */
public class Main {
    private static int[] arr;
    private static boolean[] visited;
    private static int n ,s, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        /**
         * 4C1, 4C2, 4C3, 4C4
         */
        for (int i = 1; i <= n; i++) {
            combination(0, i);
        }

        System.out.println(result);
    }
    // -7 -3 -2 5 8
    private static void combination(int start, int r) { // r : 조합의 갯수를 의미, start : 조합에 사용될 정수 배열의 idx 값을 의미
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum == s) {
                result++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i+1, r-1);
            visited[i] = false;
        }
    }
}