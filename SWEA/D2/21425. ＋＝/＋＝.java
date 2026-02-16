import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int N = sc.nextInt();
			
			int count = 0;
			while((A <= N) && (B <= N)) { // A와 B 둥 중 하나라도 N을 초과하면 종료
				if(A >= B) { // 작은 값에 큰 값을 더하면 값이 더 빠르게 증가
					B += A;
					count++;
				} else {
					A += B;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}