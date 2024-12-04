import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Case1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Tower[] towers = new Tower[n];
        int top = -1; // 스택의 top을 가리키는 인덱스
        
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());
            
            while (top >= 0 && value > towers[top].high) {
                top--;
            }
            
            if (top == -1) {
                sb.append(0).append(" ");
            } else {
                sb.append(towers[top].idx).append(" ");
            }
            
            towers[++top] = new Tower(i, value);
        }
        
        System.out.println(sb);
        br.close();
    }
}

class Tower {
    public int idx;
    public int high;
    
    public Tower(int idx, int high) {
        this.idx = idx;
        this.high = high;
    }
}
