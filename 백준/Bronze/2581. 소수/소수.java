import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int minNum = Integer.MAX_VALUE;
		int sumNum = 0;
		
		// 가장 작은 수를 찾기 위해 역순으로 진행 
		for(int n=M; n>=N; n--) {
			int find = n;
			
			if(find == 1) continue;
			
			boolean possible = true;
			for(int i=2; i<=n-1; i++) {
				if(find % i == 0) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				sumNum += find;
				minNum = find;
			}
		}
		
		if(sumNum == 0 && minNum == Integer.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(sumNum);
			System.out.println(minNum);
		}
	}
}