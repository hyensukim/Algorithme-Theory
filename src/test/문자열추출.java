package test;

public class 문자열추출 {
    public static void main(String[] args) {
        String[] strArr = {
            "abasdfk.svsmkagksa.xcvmkadkbmeksrbmosdmrgkmdslb.asdmfkvskjflk.zip",
            "김현수.xml",
            "아프리카..img.cor"
        };
        for(String str : strArr) {
            int flag = str.lastIndexOf(".");
            String name = str.substring(0,flag);
            String extension = str.substring(flag+1);
            System.out.println("파일명 : " + name);
            System.out.println("확장자 : " + extension);
        }
    }
}
