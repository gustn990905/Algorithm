import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] arr = new int[10];
			
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr); // 오름차순 정렬
			int total = 0;
			
			/*
			 * 최솟값(arr[0])과 최댓값(arr[9]) 제외
			 * arr[1] ~ arr[8] 까지 합산
			 */
			
			for(int i=1; i<9; i++) {
				total += arr[i];
			}
			
			/*
			 * 8개의 평균 계산
			 * total / 8.0 -> 실수 나눗셈
			 * %.0f -> 소수점 첫째 자리에서 반올림 후 정수 형태 출력
			 */
			
			System.out.printf("#%d %.0f\n", t, total / 8.0);
		}
	}
}