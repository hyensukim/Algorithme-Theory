package day_240408.알고리즘수업_너비우선탐색1_24444;
import java.io.*;
import java.util.*;
/**
 * 
 * 96088KB
 * 1120ms
 * 50분
 * O(NlogN)
 * 
 * 1. 문제 파악
 * N개의 정점과 M개의 간선으로 이뤄진 무방향 그래프. 간선의 가중치는 1(정점에서 다른 정점으로 이동 시 비용)
 * 정점 R에서 시작, 너비 우선 탐색 시 노드의 방문 순서 출력
 * 인접 정점은 오름차순
 * 
 * 2. 접근 방법
 * BFS 핵심로직
 * - 인접 리스트 생성
 * - 방문 배열
 * - 큐에 담아서, 너비 탐색 수행
 */
public class Main {
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int count = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        result = new int[n+1];
        for(int i=0; i<=n; i++){
            nodeList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
        }

        visited[r] = true;
        bfs(r);

        for(int i=1; i<=n; i++){
            sb.append(result[i]+"\n");
        }

        br.close();

        System.out.println(sb);
    }

    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            int n = q.poll();
            result[n] = count++;
            
            Collections.sort(nodeList.get(n));
            for(int adj : nodeList.get(n)){
                if(!visited[adj]){
                    visited[adj] = true;
                    q.offer(adj);
                }
            }
        }
    }
}
