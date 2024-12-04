package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        br.close();

        long a = Long.parseLong(s[0]); // 최소

        long b = Long.parseLong(s[1]); // 최대

        boolean[] isPrime = new boolean[(int) Math.sqrt(b) + 1];

        Arrays.fill(isPrime, true);

        // '에라토스테네스 체' 를 활용하여 소수 걸러내기
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i])
                continue;

            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        // 거의 소수여부 확인하기
        // log a (b) = log c (b) / log c (a) 공식을 이용하여 지수 구하기
        // int count = 0;
        // for (int i = 2; i < isPrime.length; i++) {
        // if (isPrime[i]) {
        // if (i >= a) {
        // double res = Math.log((double) b) / Math.log((double) i);
        // if (res >= 2)
        // count += ((int) res - 1);
        // }
        // }
        // }

        // System.out.println(count);

        // 주어진 범위 [A,B]에 해당하는 '거의 소수'의 개수 찾기
        int answer = 0;
        // 찾아낸 소수에 대해서 N제곱이 범위에 해당하는지 찾기 시작
        for (int i = 2; i < isPrime.length; i++) {
            // i가 소수인 경우에만
            if (isPrime[i]) {
                long temp = i;
                // 자료형의 범위를 넘어가지 않게 양변을 i로 나눈값으로 범위에 속하는지 판단
                while (temp <= (double) (b / i)) {
                    if (temp >= (double) (a / i)) {
                        answer++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(answer);

    }
}
