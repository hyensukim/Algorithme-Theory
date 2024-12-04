package day_240911;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Case1{
    public static void main(String[] args)throws IOException {
        Long start = System.currentTimeMillis();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new LinkedList<>();
        for(char ch : str.toCharArray()) {
            String separatedStr = String.valueOf(ch);
            list.add(separatedStr);
        }
        
        int cursor = str.length();
        int nums = Integer.parseInt(br.readLine());
        for(int i=0; i<nums; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command) {
                case "L" : 
                    if(cursor > 0) {
                        cursor--; 
                    } 
                    break;
                case "D" :
                    if(cursor < list.size()) {
                        cursor++;
                    } 
                    break;
                case "B" :
                    if(cursor > 0) {
                        list.remove(--cursor);
                    }
                    break;
                default :
                    list.add(cursor, st.nextToken());
                    cursor++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        System.out.println(sb.toString());
        br.close();
        Long end = System.currentTimeMillis();
        System.out.println();
        System.out.printf("%d ms",end - start);
    }
}