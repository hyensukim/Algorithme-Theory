package day_240912;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main{
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        int l = Integer.parseInt(br.readLine());
        while(l-- > 0){
            String str = br.readLine();
            
            checkCommand(str);
            
            List<String> list = new LinkedList<>();
            ListIterator<String> iter = list.listIterator();
            for(char command : str.toCharArray()) {
                switch(command) {
                    case '<' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>' :
                        if(iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default : 
                        iter.add(String.valueOf(command));
                }
            }
            
            for(String s : list) {
                sb.append(s);
            }
            sb.append("\n");
        }
        
        br.close();
        System.out.print(sb.toString());
    }
    
    private static boolean checkCommand(String str) {
        if(str.contains("<>-")) {
            return true;
        }
        return  false;
    }
}
