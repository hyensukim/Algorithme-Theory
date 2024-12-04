package day_240406.창고다각형_2304;
import java.io.*;
import java.util.*;
/**
 * 
 * 14588KB
 * 152ms
 * 60분 초과
 * O(n)
 * 
 * 1. 문제파악
 * 폭 1m, 높이는 다를 수 있다(같을수도 있음)
 * 1. 수평 부분과 수직부분으로 구성, 모두 연결(한 좌표-index 공유)
 * 2. 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 합니다.(ㅜ)
 * 3. 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 합니다.(ㅜ)
 * 4. 지붕의 가장자리는 땅에 닿아야 한다.(0이 들어간 좌표)
 * 5. 비가 올 때 물이 고이지 않도록 지붕의 어떠 부분도 오목하게 들어간 부분이 없어야 한다.(일련의 좌표?)
 * 다각형의 면적이 가장 *작은 창고 만들기,
 * 
 * 기둥 갯수(N) : 1~1000, 왼쪽 면의 위치 L, 높이 H : 1~1000
 * 
 * 2. 접근 방법
 * 주어진 기둥 중 L의 최솟값 부터 최댓값까지를 탐색하면서 높이만큼 더해주면, 전체 넓이가 나옵니다.
 * 이를 위해서는 기둥을 위치별로 정렬을 해줘야합니다.
 * 이전의 높이 중 최대 높이의 값으로 더해줘야 합니다.
 * 간과한 것이 있었다... 지붕은 오목한 부분이 없어야 하므로, 가운쯤이 가장 높아야 합니다.
 * 따라서, 지붕의 중간쯤(비대칭일 수 있음)를 기준으로 좌 ->  우, 우 -> 좌로 더해주고, 마지막에 가운데 지붕 값을 빼줍니다.
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Integer> map = new HashMap<>();

        int n  =Integer.parseInt(br.readLine());
        int min_point = Integer.MAX_VALUE;
        int max_point = Integer.MIN_VALUE;
        int tmp_max = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 위치
            int h = Integer.parseInt(st.nextToken()); // 높이
            map.put(l, h);

            tmp_max = Math.max(tmp_max,h);
            min_point = Math.min(min_point, l);
            max_point = Math.max(max_point, l);
        }
        
        int result = 0;
        int mid_point = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == tmp_max){
                mid_point = entry.getKey();
            }
        }
        int max_height = Integer.MIN_VALUE;
         for(int i=min_point; i <= mid_point; i++){
            int height = map.getOrDefault(i, 0);
            max_height = Math.max(max_height, height);
            result += max_height;
        }
        max_height = Integer.MIN_VALUE;
        for(int i=max_point; i > mid_point; i--){
            int height = map.getOrDefault(i, 0);
            max_height = Math.max(max_height, height);
            result += max_height;
        }

        br.close();

        System.out.println(result);
    }
}
