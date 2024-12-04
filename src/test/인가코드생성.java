package test;

public class 인가코드생성 {
    public static void main(String[] args) {
        //Given
        char[] charNums = new char[] { '0','1','2','3','4','5','6','7','8','9'};
        char[] charAlphas = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
                'S','T','U','V','W','X','Y','Z'};
        char[] charSpecials = new char[] {'!','@','#','$','%','^','&'};
        StringBuilder str = new StringBuilder();

        //When
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            idx = (int) (charNums.length * Math.random());
            str.append(charNums[idx]);
        }

        for(int i=0; i < 3; i++){
            idx = (int) (charAlphas.length * Math.random());
            str.append(charAlphas[idx]);
        }

        for(int i=0; i < 2; i++){
            idx = (int) (charSpecials.length * Math.random());
            str.append(charSpecials[idx]);
        }

        //Then
        System.out.println(str);
    }
}
