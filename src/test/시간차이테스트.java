package test;

import java.time.Duration;
import java.time.LocalDateTime;

public class 시간차이테스트 {
    public static void main(String[] args) {
        // 특정 시간 설정 예시 (예: 2024년 4월 20일 15시 30분)
        LocalDateTime specificTime = LocalDateTime.of(2024, 4, 21, 1, 45);

        // 현재 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        
        // 두 시간 사이의 차이 계산
        Duration duration = Duration.between(specificTime, now);

        System.out.println(duration.toHours());
        
        // 차이가 1일보다 작은지 확인
        boolean isLessThanADay = Math.abs(duration.toHours()) <= 24;

        System.out.println("Is the time difference less than a day? " + isLessThanADay);
    }
}
