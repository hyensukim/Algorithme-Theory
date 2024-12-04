import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[][] arr = new int[2][26];
            for(int i = 0; i < arr.length; i++){
                char[] chars = st.nextToken().toCharArray();
                for(char ch : chars){
                    arr[i][ch-97]++;
                }
            }
            
            int count = 26;
            for(int i=0; i<26; i++){
                if(arr[0][i] == arr[1][i]){
                    count--;
                }
            }
            
            if(count == 0){
                sb.append("Possible").append("\n");
            } else {
                sb.append("Impossible").append("\n");
            }
        }
        
        br.close();
        
        System.out.println(sb);
    }
}