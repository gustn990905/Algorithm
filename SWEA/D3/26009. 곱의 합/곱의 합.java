import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			
			// 먼저 a, b, c를 MOD로 나눈 나머지를 구함
            // -> 큰 수를 그대로 곱하면 overflow 위험이 있기 때문
			long a1 = a % 998244353;
			long b1 = b % 998244353;
			long c1 = c % 998244353;
			
			// (a+1), (b+1), (c+1)도 마찬가지로 MOD 처리
			long a2 = (a+1) % 998244353;
			long b2 = (b+1) % 998244353;
			long c2 = (c+1) % 998244353;
			
			long result = a1;
			
			// result = a(a+1)/2 부분 계산
            // 먼저 a1 * a2 를 하고
            // 그 다음 2로 나눈 뒤
            // MOD를 취함
			result = result * a2 / 2 % 998244353;
			result = result * b1 % 998244353;
			result = result * b2 / 2 % 998244353;
			result = result * c1 % 998244353;
			result = result * c2 / 2 % 998244353;
			
			System.out.println(result);
		}
	}
}