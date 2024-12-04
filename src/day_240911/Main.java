package day_240911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        Long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<String> list = new LinkedList<>();
        for(char ch : str.toCharArray()) {
            String separatedStr = String.valueOf(ch);
            list.add(separatedStr);
        }
        
        int nums = Integer.parseInt(br.readLine());
        ListIterator<String> iter = list.listIterator(list.size());
        for(int i=0; i<nums; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command) {
                case "L" : 
                    if(iter.hasPrevious()) {
                        iter.previous();
                    } 
                    break;
                case "D" :
                    if(iter.hasNext()) {
                        iter.next();
                    } 
                    break;
                case "B" :
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default :
                    iter.add(st.nextToken());
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