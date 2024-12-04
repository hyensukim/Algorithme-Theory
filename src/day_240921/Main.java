import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        long[] towers = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<=n; i++) {
            towers[i] = Long.parseLong(st.nextToken());
        }
        
        for(int i=n; i>0; i--) {
            long value = towers[i];
            for(int j=i-1; j>=0; j--) {
                long relative = towers[j];
                if(value <= relative) {
                    sb.append(j).append(" ");
                    break;
                } else if(j == 0) {
                    sb.append(j).append(" ");
                }
            }
        }
        System.out.println(sb.reverse().toString().trim());
        br.close();
    }
}