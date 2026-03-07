import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수 입력

		for(int t=0; t<T; t++) { // 테스트 케이스 반복
			long L = sc.nextLong(); // 고객이 사고 싶은 최소 음료 개수
			long R = sc.nextLong(); // 고객이 사고 싶은 최대 음료 개수

			/*
			 고객은 N개의 음료를 사고 싶을 때
			 묶음: N / X
			 단품: N % X

			 하지만 단품 개수가 X/2 이상이면
			 단품 대신 묶음 하나를 더 구매한다고 가정한다.

			 즉 조건은
			 N % X ≥ X/2

			 이 조건이 모든 N (L ≤ N ≤ R)에 대해 성립해야 한다.

			 가능한 X가 존재하려면
			 R < 2L
			*/

			if(R < 2*L) // 위 조건을 만족하면 가능한 X가 존재
				System.out.println("yes");
			else // 조건을 만족하지 않으면 불가능
				System.out.println("no");
		}
	}
}