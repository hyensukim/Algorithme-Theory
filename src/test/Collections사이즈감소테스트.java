package test;

import java.util.*;

public class Collections사이즈감소테스트 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(int i=0; i<list.size(); i++) {
            list.remove(i);
        }

        System.out.println(list);
    }
}
