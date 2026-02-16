import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A와 B의 가위바위보 선택 입력
		// 1: 가위, 2: 바위, 3: 보
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
			System.out.println("A"); // A 승리
		} else { // 그 외의 경우는 B 승리
			System.out.println("B");
		}
	}
}