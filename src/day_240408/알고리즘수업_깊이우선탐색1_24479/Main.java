package day_240408.알고리즘수업_깊이우선탐색1_24479;
import java.io.*;
import java.util.*;
/**
 * 114888KB
 * 1104ms
 * 60분
 * O(NlogN)
 * 
 * 1. 문제파악
 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프.
 * 정점 번호는 1~N, 모든 간선의 가중치는 1이다.
 * 깊이 우선 탐색으로 구현 시, 노드 방문 순서를 출력
 * 정점 번호를 *오름차순으로 방문합니다.
 * 
 * N(정점 갯수) : 5~10만, M(간선 갯수) : 1~20만, R(시작 정점) : 1~N
 * M개 줄에 간선 정보 u,v가 주어집니다. u,v : 1~N(u!=v)
 * 첫째 줄부터 N개의 정수를 한개씩 출력합니다. 
 * i번째 줄에는 정점의 방문 순서를 출력합니다. 
 * - 시작 정점의 방문 순서는 1입니다. 
 * - 시작 정점에서 방문할 수 없는 경우 0을 출력합니다.
 * 
 * 2. 접근 방법
 * DFS 핵심
 * - 인접 리스트 생성
 * - 방문 배열 생성
 * - 재귀 함수 구현
 * 
 * 인접 리스트 생성 - 노드에 인접한 노드들을 담은 리스트.
 * 방문 리스트(boolean[]) 생성 - 해당 노드에 방문여부를 확인하여 중복되는 방문을 줄여줌
 * 결과 배열(int[])생성 - 해당 인덱스를 정점으로 생각하고, count 값을 담아줍니다.
 * 정답 출력 시, 1~N 까지의 결과 배열에 담긴 count 값을 출력해줍니다.
 * 만약, R을 기준으로 깊이 우선 탐색을 수행한 뒤에도 방문하지 않은 노드는 0의 depth를 담아줍니다.
 * 
 * 3. 주의할점
 * 인접리스트 탐색 순서가 오름차순으로 진행된다는점
 * 각 노드의 방문 순서를 counting 해야된다는 점
 */
public class Main {
    static ArrayList<ArrayList<Integer>> nodeList;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 인접 리스트 및 방문배열 초기화
        nodeList = new ArrayList<>();
        visited = new boolean[n+1];
        result = new int[n+1];
        for(int i=0; i<=n; i++){
            nodeList.add(new ArrayList<Integer>());
        }

        // 그래프 노드를 인접 리스트에 담기
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
        }

        // 각 인접 노드들 오름차순으로 정렬 및 dfs 수행; - O(N)

        for(int i=1; i<=n; i++){
            sb.append(result[i]+"\n");
        }

        br.close();

        System.out.println(sb);
    }

    static void dfs(int node, int depth){
        visited[node] = true; // 방문 체크
        result[node] = depth; // 횟수 카운팅
        Collections.sort(nodeList.get(node));// O(NlogN)

        // 인접 노드를 깊이 파고들어서 방문하지 않은곳 탐색
        for(int adj : nodeList.get(node)){ // adjacent 인접
            if(!visited[adj]){
                dfs(adj,depth+1);
            }
        }
    }
}