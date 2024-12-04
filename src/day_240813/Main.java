package day_240813;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        /**
         * NOTE : 크기가 다른 경우, 크기가 큰쪽을 b에 작은쪽을 a로 옮겨주는 작업 선행.
         */
        if(a>b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        if(a==b)
            sb.append(b-a).append("\n");
        else sb.append(b-a-1).append("\n");
        for(long i=a+1;i<b;i++){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}