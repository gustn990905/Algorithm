import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			long N = Math.abs(A - B);

			// 두 수의 차이가 1보다 작으면 소수로 같아지게 만들 수 없음
			if (A > B) {
			    System.out.println("#" + t + " -1");
			}
			else if(N==0) System.out.println("#" + t + " " + 0);
			else if (N <= 1)
				System.out.println("#" + t + " " + (-1));

			// 두 수의 차이가 1초과인 경우에만 확인
			else {
				long result = find(N);
				System.out.println("#" + t + " " + result);
			}
		}
	}

	// 최대한 많은 소수를 활용해서 값을 같게 하려면 최대한 작은 수를 많이 활용하는 방법
	// 소수 중 가장 작은 수는 2
	// 짝수인 경우 2로 나눈 몫이 결과
	// 홀수인 경우 다음으로 작은 소수인 3 활용
	static long find(long n) {
		int cnt = 0;

		if (n % 2 == 0)
			return n / 2;
		else {
			n -= 3;
			return 1 + n / 2;
		}
	}
}