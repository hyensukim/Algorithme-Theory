package test;

public class 부동소수점테스트 {

    public static void main(String[] args) {
        double d = 0.1;

        for(int i=0; i<100; i++){
            d += 0.1;
        }

        System.out.println(d);

    }
    
}
