package day_240409.중량제한_1939;
import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Bridge> bridges = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 섬갯수
        int m = Integer.parseInt(st.nextToken()); // 다리갯수

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // in
            int b = Integer.parseInt(st.nextToken()); // out
            long c = Integer.parseInt(st.nextToken()); // limit
            
            bridges.add(new Bridge(a, b, c));
            bridges.add(new Bridge(b, a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start_land = Integer.parseInt(st.nextToken());
        int end_land = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];

        bfs();

        br.close();
    }

    static void bfs(){

    }

    static class Bridge{
        int in;
        int out;
        long limit;

        Bridge(int in, int out, long limit){
            this.in = in;
            this.out = out;
            this.limit = limit;
        }
    }
}
