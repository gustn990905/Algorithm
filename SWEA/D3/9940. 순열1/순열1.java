import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			// 입력 값을 저장할 배열 (1~N 범위 가정)
			int[] arr = new int[N+1];
			
			// 해당 숫자가 이미 등장했는지 확인하기 위한 체크 배열
			boolean[] check = new boolean[N+1];
			
			// 중복이 발생했는지 여부 판단 변수
			boolean no = false;
			
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();
			}
			
			// 중복 검사
			for(int n=0; n<N; n++) {
				// 아직 등장하지 않은 숫자라면
				if(!check[arr[n]]) {
					check[arr[n]] = true; // 등장 표시
				} 
				
				// 이미 등장한 숫자라면 -> 중복 발생
				else {
					no = true;
					break; // 더 검사할 필요 없음
				}
			}
			
			if(no) {
				System.out.println("#" + t + " " + "No");
			} else {
				System.out.println("#" + t + " " + "Yes");
			}
		}
	}
}