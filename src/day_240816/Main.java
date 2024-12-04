package day_240816;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        long sum = 0L;
        
        for(int i=0; i<9; i++){
            Integer key = Integer.parseInt(br.readLine());
            list.add(key);
            sum += key;
        }
        
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(sum - (list.get(i) + list.get(j)) == 100){
                    list.set(i,0);
                    list.set(j,0);
                    Collections.sort(list);
                    list.stream().filter(x -> x != 0).forEach(System.out::println);
                    return;
                }
            }
        }
        
        br.close();
    }
}
