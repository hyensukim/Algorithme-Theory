package test;

public class callbyvaluetest {
    public static void main(String[] args) {
        int x = 0;
        modify(x);
        System.out.println(x);

        A a = new A();
        System.out.println(a.num);
        modifyRef(a);
        System.out.println(a.num);
    }

    public static void modify(int x){
        x = 10;
    }

    public static void modifyRef(A a){
        a = new A(); // 추가
        a.num = 10;
    }
}

class A{
    int num = 0;
}
