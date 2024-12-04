package day_240412.최소비용구하기_1916;
import java.io.*;
import java.util.*;
/**
 * 
 * 50472KB
 * 536ms
 * 
 * 1. 문제 파악
 * N1 ->M(버스)-> Ni(도시)
 * 버스 비용 최소화
 * 
 * 도시의 갯수 1~1000, 버스의 갯수 1~10만, 버스 정보 (출발 도시, 도착 도시, 버스 비용 - 0~10만)
 * 출발 도시, 도착 도시 지정
 * 
 * 최소비용 구하기
 * 
 * 2. 접근 방법
 * 주어진 제한 시간이 매우 짧다... bfs 가능할까??
 * 완전탐색 말고 다른 탐색법으로?? 다익스트라??
 * 
 * 시작부터 끝까지, 최단 경로를 탐색하는 알고리즘
 * 최소 비용, 최단 거리를 탐색하는 것에 최적화된 알고리즘
 * 
 * 버스의 최소 비용이 들기 위해서는 갈 수 있는 방법 중에서 최솟값을 비교해야한다.
 * 
 * 다익스트라
 * - PriorityQueue를 활용한 최단거리/ 최소비용 탐색 방식(최소 - 오름차순, 최대 - 내림차순)
 * 1 2 3 (start: 1, end: 3)
 * 1-2-3, 1-3 연결된 경우, 1-2 + 2-3 과 1-3의 값을 비교해서 더 짧은 거리를 비교.
 * - 문제에 적용해보면, 도시로 가능 최소비용 탐색
 * 
 * 3. 주의사항
 * - 버스가 없는 도시 간에(간선이 없는 노드)는 비용(값)을 최댓값으로 지정해줍니다.
 * - 최솟값 연산 시 잘못된 값이 나오는 것을 방지하기 위함.
 */
public class Main {
    static List<City>[] list; // 0 : 출발, 1 : 도착
    static boolean[] visited;
    static int[] short_route;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 섬 갯수
        int m = Integer.parseInt(br.readLine()); // 버스 갯수

        short_route = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){// 도시로 이동 시 비용 초기화
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fare = Integer.parseInt(st.nextToken());
            list[from].add(new City(to, fare));
        }

        st = new StringTokenizer(br.readLine());
        int fromCity = Integer.parseInt(st.nextToken());
        int toCity = Integer.parseInt(st.nextToken());

        findShortest(fromCity);

        int result = short_route[toCity];

        br.close();

        System.out.println(result);
    }

    static void findShortest(int from){
        Queue<City> pq = new PriorityQueue<>();
        
        Arrays.fill(short_route,Integer.MAX_VALUE);
        short_route[from] = 0;

        pq.offer(new City(from,0));

        while(!pq.isEmpty()){
            City now = pq.poll();
            
            if(!visited[now.to]){
                visited[now.to] = true;

                for(City next : list[now.to]){
                    int stack = next.fare + short_route[now.to];
                    if(short_route[next.to] >= stack){
                        short_route[next.to] = stack;
                        pq.offer(new City(next.to,stack));
                    }
                }
            }
        }
    }

    static class City implements Comparable<City>{
        int to;
        int fare;

        City(int to, int fare){
            this.to = to;
            this.fare = fare;
        }

        @Override
        public int compareTo(City o) {
            return this.fare - o.fare;
        }
    }
}
