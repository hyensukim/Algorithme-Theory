package day_240411.마법상어와비바라기_21610;
import java.io.*;
import java.util.*;
/**
 * 18832KB
 * 244ms
 * 
 * - 현재까지 구름 이동 관련 로직에 대해 고민해보고 구현하려 했으나,
 *  실패하였습니다..ㅜ
 * 
 * 1. 문제 파악
 * 마법사 상어;;
 * 비바라기 범위 N * N - 한칸마다 바구니(물 제한 X)
 * arr[r,c] = 바구니에 담기 물의 양
 * 열 1 ~ N 1 ~
 * 행 1 ~ N 1 ~
 * 
 * 비바라기 시전 시, N,1 - N,2 - N-1,1 - N-1,2 비구름이 생성.
 * M번 이동하라고 명령 -> di(방향 - 8개), si(거리)
 * 8개 방향으로 이동
 * 
 * 로직
 * 1. 해당 구름은 동시에 이동한다.
 * 2. 비를 내리고, 바구니에 물이 1개씩 증가
 * 3. 구름이 모두 사라짐.(방문 표시 필수!)
 * 4. 증가한 물의 칸에 물복사버그 마법 시전 
 *  - 대각선, 거리1, 바구니 값이 0 이상인 갯수 +
 *  - 배열 범위 넘어가는 건 고려 X
 * 5. 바구니 값이 2이상이면, 구름 생성, 값-2
 *  - 구름이 사라졌던 칸은 구름 생성 X
 * 
 * 마법 시전 후 전체 물의 양의 합
 * 
 */
public class Main {
    
    // 이동 방향
    static int[] dirX = {0,-1,-1,-1,0,1,1,1};
    static int[] dirY = {-1,-1,0,1,1,1,0,-1};

    // 대각선 방향
    static int[] crossX = {-1,-1,1,1};
    static int[] crossY = {-1,1,1,-1};

    static Queue<Coordinator> clouds; // 구름 위치 n의 값들을 담기
    static int[][] baskets;
    static boolean[][] visited;

    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 배열 범위, 시작값
        m = Integer.parseInt(st.nextToken()); //  명령어 갯수

        baskets = new int[n][n];
        visited = new boolean[n][n];

        // 바구니 초기화
        for(int x=0; x<n; x++){
            st = new StringTokenizer(br.readLine());
            for(int y=0; y<n; y++){
                baskets[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 좌표 초기화
        clouds = new ArrayDeque<>();
        clouds.offer(new Coordinator(n - 1, 0));
        clouds.offer(new Coordinator(n - 1, 1));
        clouds.offer(new Coordinator(n - 2, 0));
        clouds.offer(new Coordinator(n - 2, 1));

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken())-1; // 방향
            int si = Integer.parseInt(st.nextToken()); // 이동 거리

            // 1. 동시에 이동
            movement(di, si);
            // System.out.println(Arrays.deepToString(baskets));
            // 2. 물뿌리기, 사라지기
            fillWater();
            // System.out.println(Arrays.deepToString(baskets));
            // 3. 대각선 물복사 - 배열 범위 내에서 counting
            checkCrossLine();
            //System.out.println(Arrays.deepToString(baskets));
            // 4. 구름 생성 - cloud_area 확인
            makeCloud();
            //System.out.println(Arrays.deepToString(baskets));

            visited = new boolean[n][n];
        }

        // System.out.println(Arrays.deepToString(baskets));

        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                sum += baskets[i][j];
            }
        }

        br.close();

        System.out.println(sum);
    }

    static void movement(int dir, int len){
        for(Coordinator now : clouds){
            int nx = (n + now.x + dirX[dir] * (len % n)) % n;
            int ny = (n + now.y + dirY[dir] * (len % n)) % n;

            now.x = nx;
            now.y = ny;
        }
    }

    static void fillWater(){
        for(Coordinator now : clouds){
            baskets[now.x][now.y]++;
        }
    }

    static void checkCrossLine(){
        while(!clouds.isEmpty()){
            Coordinator now = clouds.poll();
            visited[now.x][now.y] = true;
            int count = 0;
            for(int i=0; i<4; i++){
                int x = now.x + crossX[i];
                int y = now.y + crossY[i];
                if(x >= 0 && x < n && y >= 0 && y < n && baskets[x][y] > 0) count++;
            }
            baskets[now.x][now.y] += count;
        }
    }

    static void makeCloud(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && baskets[i][j] >= 2){
                    clouds.offer(new Coordinator(i, j));
                    baskets[i][j] -= 2;
                }
            }
        }
    }

    static class Coordinator{
        int x;
        int y;
        Coordinator(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}