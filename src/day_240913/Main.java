package day_240913;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");
        List<Integer> list = new ArrayList<>();
        Queue<Integer> answer = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) {
            list.add(i);
        }
        int k = Integer.parseInt(st.nextToken());
        int idx = 0;
        while (!list.isEmpty()) {
            idx = (idx+k-1)%list.size();
            answer.add(list.remove(idx));
        }
        while(answer.size() > 1) {
            sb.append(answer.poll());
            sb.append(", ");
        }
        sb.append(answer.poll()).append(">");
        System.out.println(sb);
    }
}
