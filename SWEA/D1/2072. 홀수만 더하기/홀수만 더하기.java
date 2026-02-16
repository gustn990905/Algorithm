import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 입력을 받기 위한 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int T = sc.nextInt();
		
		// 각 테스트 케이스 반복
		for (int t = 1; t <= T; t++) {
			
			// 10개의 정수를 저장할 배열 생성
			int[] arr = new int[10];
			
			// 홀수의 합을 저장할 변수
			int result = 0;
			
			// 배열 길이만큼 반복하면서 입력 처리
			for(int i = 0; i < arr.length; i++) {
				
				// 정수 입력 받아 배열에 저장
				arr[i] = sc.nextInt();
				
				// 입력값이 홀수라면 (2로 나눈 나머지가 1)
				if(arr[i] % 2 == 1) {
					// 결과값에 해당 홀수를 누적 합산
					result += arr[i];
				}
			}
			
			// 문제 형식에 맞게 출력 (#테스트번호 결과값)
			System.out.println("#" + t + " " + result);
		}
	}
}