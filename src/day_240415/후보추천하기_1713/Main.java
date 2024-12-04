package day_240415.후보추천하기_1713;
/**
 * 후보 게시 및 횟수 표시 규칙
 * - 사진틀 비어있음
 * - 추천 받은 학생의 사진이 반드시 사진틀에 게시
 * - 비어있는 사진틀이 없으면, 추천수가 가장 작은 후보 삭제한 뒤 해당 틀에 게시.
 *  - 이 때, 횟수가 가장 적은 후보 2명 이상인 경우, 더 오래된 사진을 삭제.
 * - 이미 게시된 경우, 추천수 증가
 * - 틀에서 삭제될 경우, 추천수 0으로 초기화
 * 
 * 사진틀 갯수 N(1~20)
 * 총 추천 횟수(1~1000)
 * 추천받은 학생 번호(1~100)
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

    static final int cand_num = 101;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Candidate[] candidates = new Candidate[cand_num];
        Queue<Candidate> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            Candidate candidate = candidates[num];

            if(candidate == null){
                candidate = new Candidate(num, 0,0,false);
                candidates[num] = candidate;
            }

            if(candidate.isCandidate){
                candidate.cnt++;
            }
            else{
                if(q.size() == n){
                    q.peek().isCandidate = false;
                    q.poll();
                }
                
                candidate.cnt = 1;
                candidate.order = i;
                candidate.isCandidate = true;
                q.offer(candidate);
            }
        }

        List<Candidate> list = q.stream().collect(Collectors.toList());
        list.sort((o1,o2) -> o1.num - o2.num);

        for(Candidate c : list){
            sb.append(c.num).append(" ");
        }

        System.out.println(sb);
    }

    static class Candidate implements Comparable<Candidate>{
        int num;
        int cnt;
        int order;
        boolean isCandidate;
        

        Candidate(int num, int cnt, int order, boolean isCandidate){
            this.num = num;
            this.cnt = cnt;
            this.order = order;
            this.isCandidate = isCandidate;
        }

        @Override
        public int compareTo(Candidate o) {
            if(this.cnt == o.cnt){
                return this.order - o.order;
            }
            else{
                return this.cnt - o.cnt;
            }
        }
    }
}
