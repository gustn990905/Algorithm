import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N]; // N개의 정수를 저장할 배열 생성
		
		for(int n=0; n<N; n++) {
			arr[n] = sc.nextInt();
		}
		
		Arrays.sort(arr); // 배열을 오름차순으로 정렬
		System.out.println(arr[N/2]); // 정렬 후 중앙 인덱스(N/2)의 값을 출력
	}
}