package day_240412.회의실배정_1931;
/**
 * 
 * 44224KB
 * 584ms
 * 
 * 1. 문제 파악
 * 하나의 회의실, N개의 회의실 사용표, 시작 시간과 끝나는 시간 정해짐
 * 두 회의는 겹치지 않으며, 한번 시작하면 중간에 중단했다가 다시하는거 없음
 * 회의가 끝나는 것과 동시에 다른 회의 시작가능(회의1 끝점과 회의2 시작점 같을 순 있음)
 * 하나의 회의가 시작과 동시에 끝나는 경우도 있음(회의1 시작점 == 회의1 끝점)
 * 
 * N : 1~10만, 시간 : 0 ~ 2^31-1
 * 사용할 수 있는 회의의 최대 갯수 출력
 * 
 * 2. 접근 방법
 * 예제를 확인해보면, 끝점이 작은것을 우선순위로 선택된다.
 * 끝점이 같은경우는? 시작점이 작은것을 우선순위로 선택된다.
 * 그렇다면, 위의 상황처럼 정렬을 한뒤, 순차적으로 선택된 끝점보다 시작점이 
 * 크거나 같은 항목을 카운팅을 해나가고, 끝점을 선택된 요소의 끝점으로 업데이트 해준다.
 * 
 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Brownbag[] meetings = new Brownbag[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Brownbag(s,e);
        }

        Arrays.sort(meetings);

        int count = 0;
        int end = 0;
        for(Brownbag meeting : meetings){
            if(end <= meeting.startTime){
                end = meeting.endTime;
                count++;
            }
        }


        br.close();

        System.out.println(count);
    }

    static class Brownbag implements Comparable<Brownbag>{
        int startTime;
        int endTime;

        Brownbag(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Brownbag o) {
            if(this.endTime != o.endTime){
                if(this.endTime > o.endTime) return 1;
                else return -1;
            }
            else{
                if(this.startTime > o.startTime) return 1;
                else if(this.startTime < o.startTime) return -1;
                else return 0;
            }
        }
    }
}
