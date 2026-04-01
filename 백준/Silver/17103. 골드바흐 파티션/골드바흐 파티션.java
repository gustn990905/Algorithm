import java.util.Scanner;

public class Main {
	
	static boolean[] isComposite; // true = 합성수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sieve(1000001);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int cnt = 0;
			
			// 5인 경우 2+3과 3+2 모두 소수의 합으로 count
			// 위와 같은 경우는 같은 경우가 두 번 count 되기 때문에 N/2까지만 확인
			for (int n = 2; n<= N /2; n++) {
				if (!isComposite[n] && !isComposite[N-n])
					cnt++;
			}
			
			System.out.println(cnt);
		}
	}

	static void sieve(int n) {
		isComposite = new boolean[n];
		isComposite[0] = true;
		isComposite[1] = true;
		
		for(int i=2; i<n; i++) {
			if(!isComposite[i]) {
				for(int j=i*2; j<n; j+=i) {
					isComposite[j] = true;
				}
			}
		}
	}
}