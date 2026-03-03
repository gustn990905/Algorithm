import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// 색상의 순서를 저장한 배열 (색상환 기준)
		String[] arr = { "red", "orange", "yellow", "green", "blue", "purple" };

		for (int t = 1; t <= T; t++) {
			String c1 = sc.next();
			String c2 = sc.next();

			// 각 색상의 인덱스를 저장할 변수
			int c1Idx = 0;
			int c2Idx = 0;

			// 배열을 순회하면서 입력받은 색상의 인덱스 찾기
			for (int i = 0; i < 6; i++) { // 첫 번째 색상이 배열의 i번째와 같다면
				if (c1.equals(arr[i])) { // 해당 인덱스 저장
					c1Idx = i;
				}
				if (c2.equals(arr[i])) { // 두 번째 색상이 배열의 i번째와 같다면
					c2Idx = i; // 해당 인덱스 저장
				}
			}

			// 정반대 색상 
			if (Math.abs(c1Idx - c2Idx) == 3) {  
				System.out.println("C");
			} 
			// 인접한 색상 (색상환은 원형이므로 5도 인접)
			else if (Math.abs(c1Idx - c2Idx) == 1 || Math.abs(c1Idx - c2Idx) == 5) {
				System.out.println("A");
			} 
			// 같은 색상
			else if (Math.abs(c1Idx - c2Idx) == 0) {
				System.out.println("E");
			} 
			// 그 외 관계
			else {
				System.out.println("X");
			}
		}
	}
}