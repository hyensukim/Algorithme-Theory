package src.test;

public class trim테스트 {
    public static void main(String[] args) {
        String str = " a b ";
        System.out.println("strip() :" + str.strip()+ "_");
        System.out.println("trim :" + str.trim() + "_");
        System.out.println("replaceAll :" + str.replaceAll(" ","")+ "_");
    }
}
