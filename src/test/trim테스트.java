package test;

public class trim테스트 {
    public static void main(String[] args) {
        String str = " a b ";
        System.out.println("strip() :" + str.strip());
        System.out.println("trim :" + str.trim());
        System.out.println("replaceAll :" + str.replaceAll(" ",""));
    }
}
