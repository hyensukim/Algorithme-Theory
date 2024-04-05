package src.test;

public class 카운팅정렬{
    public static void main(String[] args) {
        int[] arr = new int[100];
        int[] counting = new int[31];
        int[] res = new int[100];

        for(int i=0; i< arr.length; i++){
            arr[i] = (int)(Math.random()*31); // 0 ~ 30
        }

        // counting 정렬

        // 과정1 - counting 배열에 요소 갯수
        for(int i=0; i < arr.length; i++){
            counting[arr[i]]++;
        }

        // 과정2 - 누적합
        for(int i=1; i < counting.length; i++){
            counting[i] += counting[i-1];
        }

        // 과정3 - arr 배열 내 counting에 해당하는 요소에 -1 후 result에 담기
        for(int i=0; i < arr.length; i++){
			int value = arr[i];
			counting[value]--;
            res[counting[value]] = arr[i];
        }

        /* 비교 출력 */
		
		// 초기 배열 
		System.out.println("array[]");
		for(int i = 0; i < arr.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// Counting 배열 
		System.out.println("counting[]");
		for(int i = 0; i < counting.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(counting[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// 정렬된 배열
		System.out.println("result[]");
		for(int i = 0; i < res.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(res[i] + "\t");
		}
		System.out.println();
	}
}
