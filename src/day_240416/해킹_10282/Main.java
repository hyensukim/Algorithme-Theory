package day_240416.해킹_10282;
import java.util.*;
import java.io.*;

public class Main {
    static List<Computer>[] computers;
    static boolean[] visited;
    static int[] time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
            int d = Integer.parseInt(st.nextToken()); // 의존성 갯수
            int c = Integer.parseInt(st.nextToken()); // 감염된 컴퓨터

            computers = new ArrayList[n+1];
            visited = new boolean[n+1];
            time = new int[n+1];

            for(int i=1; i<=n; i++){
                computers[i] = new ArrayList<>();
            }
            
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());// from
                int b = Integer.parseInt(st.nextToken());// to
                int s = Integer.parseInt(st.nextToken());// sec

                computers[b].add(new Computer(a,s));
            }

            findDefectComputer(c);

            int cnt = 0;
            int total_sec = Integer.MIN_VALUE;

            for(int t : time){
                if(t != Integer.MAX_VALUE){
                    cnt++;
                    total_sec = Math.max(total_sec, t);
                }
            }

            sb.append(cnt).append(" ").append(total_sec).append("\n");
        }

        br.close();

        System.out.println(sb.deleteCharAt(sb.length()-1));

    }

    static void findDefectComputer(int idx){ // defected computer
        Queue<Computer> pq = new PriorityQueue<>();
        Arrays.fill(time, Integer.MAX_VALUE);
        time[idx] = 0;
        pq.offer(new Computer(idx,0));

        while(!pq.isEmpty()){
            Computer dc = pq.poll();

            if(!visited[dc.idx]){
                visited[dc.idx] = true;

                for(Computer c : computers[dc.idx]){
                    int need = c.time + time[dc.idx];
                    if(time[c.idx] >= need){
                        time[c.idx] = need;
                        c.time = need;
                        pq.offer(c);
                    }
                }
            }
        }
    }

    static class Computer implements Comparable<Computer>{
        int idx; // 현재 컴퓨터 번호
        int time; // 감염 예정 시간

        Computer(int idx, int time){
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}
