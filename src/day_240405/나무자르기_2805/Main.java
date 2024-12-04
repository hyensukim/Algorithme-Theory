package day_240405.나무자르기_2805;

import java.util.*;
import java.io.*;

/**
 * 1. 문제 파악
 * 필요한 나무 M미터
 * H (0~양정수): 땅부터 H까지 올라간다. 높이가 H보다 큰 나무는 H 위의 부분이 잘리고, 낮은 나무는 잘리지 않는다.
 * ex) 20,15,10,17 의 나무가 줄지어 있는 경우, H 15설정 후 자르면 , 15, 15, 10, 15가 되어 5+2 = 7을 가져간다.
 * M만큼 가져가기 위해 설정한 H 의 최댓값을 구하시오.
 * 
 * N : 나무수(1~백만) M : 가져갈 길이(1~20억)
 * 나무의 높이 : 0~10억
 * 
 * 2. 접근 방법
 * 각 나무 길이 중 제일 긴 나무로 이분탐색을 진행해야 최소한의 결과를 보장할 수 있다.
 * 이분탐색 (O(logN))
 * - 최대높이와 최소높이를 지정한 뒤 중간값을 선정하여 탐색합니다.
 * - 최소높이는 0, 최대 높이는 나무의 길이와 같은 값입니다.
 * - 최소와 최대 중간값으로 해당 모든 나무를 자른다고 가정했을 때, 잘린 나무의 합과 M의 크기를 비교합니다.
 * - 나무 합이 M보다 큰 경우, 너무 많이 자른거기 때문에, 최솟높이를 mid+1만큼 올립니다.
 * - 나무 합이 작은 경우, 너무 조금 잘랐기 때문에, 최대높이를 mid로 변경해줍니다.
 * - min과 max를 비교하여 반복문을 돌리기 때문에, min이 max를 초과하는 탈출 포인트로 +1값을 해주는 것입니다.
 * - 마지막에는 -1을 해주어 정상적인 값을 출력해줍니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees.add(Integer.parseInt(st.nextToken()));
        }

        long max = Collections.max(trees);
        long min = 0;
        while(min < max){
            long mid = (min + max) / 2;
            int sum = 0;
            for(int tree : trees){
                if(tree -mid > 0){
                    sum += (tree - mid);
                }
            }

            if(sum < m){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }

        br.close();

        System.out.println(min-1);
    }
    
}
