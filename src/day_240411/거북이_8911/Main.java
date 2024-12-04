package day_240411.거북이_8911;
import java.io.*;
import java.util.*;
/**
 * 1. 문제 파악
 * 거북이 로봇?!
 * 1. F : 한눈금 앞으로
 * 2. B : 한눈금 뒤로
 * 3. L : 왼쪽으로 90도 회전 - 반시계
 * 4. R : 오른쪽으로 90도 회전 - 시계
 * 
 * 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이
 * 
 * 초기 포지션 - 0,0 & 북쪽
 * 선분으로 움직인 경우(x축 또는 y축 변화가 없는 경우) 넓이는 0
 * 
 * 각 테스트 케이스별로 넓이를 출력하시오
 * 
 * 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이
 * 
 * 2. 접근 방법
 *- movement
 * 방향이라는 상태값 정의. N, E, S, W 북 동 남 서(시계)
 *  F : x 또는 y 값을 1증가.
 *  B : x 또는 y 값을 1감소.
 *  L : 현재 방향을 반시계로 변경.
 *  R : 현재 방향을 시계로 변경.
 * 
 * - area
 * maxX | maxY & minX | minY 는 이동 시마다 초기화
 * x : maxX - minX
 * y : maxY - minY
 * x * y
 */
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String command = br.readLine();
            Coordinator now = new Coordinator(0, 0);
            int minX = 0;
            int minY = 0;
            int maxX= 0;
            int maxY = 0;
            for(int i=0; i<command.length(); i++){
                char ch = command.charAt(i);
                if(ch == 'L' || ch == 'R'){
                    changeArrow(now, ch);
                }
                else{
                    now = movement(now, ch);
                    minX = Math.min(minX, now.x);
                    minY = Math.min(minY, now.y);
                    maxX = Math.max(maxX, now.x);
                    maxY = Math.max(maxY, now.y);
                }
            }

            sb.append((maxX-minX)*(maxY-minY)).append("\n");
        }
        
        br.close();

        System.out.println(sb);
    }

    // 이동하기
    static Coordinator movement(Coordinator c, char ch){
        if(ch == 'F'){
            if(c.arrow == Arrow.NORTH){
                c.y++;
            }
            else if(c.arrow == Arrow.EAST){
                c.x++;
            }
            else if(c.arrow == Arrow.SOUTH){
                c.y--;
            }
            else if(c.arrow == Arrow.WEST){
                c.x--;
            }
        }
        else{
            if(c.arrow == Arrow.NORTH){
                c.y--;
            }
            else if(c.arrow == Arrow.EAST){
                c.x--;
            }
            else if(c.arrow == Arrow.SOUTH){
                c.y++;
            }
            else if(c.arrow == Arrow.WEST){
                c.x++;
            }
        }
        
        return c;
    }

    static class Coordinator{
        int x = 0;
        int y = 0;
        Arrow arrow = Arrow.NORTH;

        Coordinator(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 방향 변경
    static void changeArrow(Coordinator c, char ch){
        if(ch == 'L'){ // 왼쪽
            if(c.arrow == Arrow.NORTH) c.arrow = Arrow.WEST;
            else if(c.arrow == Arrow.WEST) c.arrow = Arrow.SOUTH;
            else if(c.arrow == Arrow.SOUTH) c.arrow = Arrow.EAST;
            else if(c.arrow == Arrow.EAST) c.arrow = Arrow.NORTH;
        }
        else{ // 오른쪽
            if(c.arrow == Arrow.NORTH) c.arrow = Arrow.EAST;
            else if(c.arrow == Arrow.WEST) c.arrow = Arrow.NORTH;
            else if(c.arrow == Arrow.SOUTH) c.arrow = Arrow.WEST;
            else if(c.arrow == Arrow.EAST) c.arrow = Arrow.SOUTH;
        }
    }
    
    enum Arrow{
        NORTH, SOUTH, WEST, EAST;
    }
}
