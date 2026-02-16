import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 목표 비밀번호(P)와 현재 시도 번호(K) 입력
		int P = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(P - K + 1);
	}
}