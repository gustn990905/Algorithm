import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 정수 N
			
			int[] arr = new int[N];
			
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();
			}
			
			// 1. 숫자 2개를 뽑아서 곱하기
			// 2. 곱한 숫자가 단조 증가하는 수인지 확인
			// 3. 단조 증가하는 수 중에서 가장 큰 값으로 갱신
			
			int result = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 같은 수를 뽑은 경우는 존재하면 안됨
					if(i==j) continue;
					
					int multi = arr[i] * arr[j];
					
					// 단조 증가하는 수이면 가장 큰 값으로 result 값 갱신
					if(check(multi)) result = Math.max(result, multi);
				}
			}
			
			if(result == 0) System.out.println("#" + t + " -1");
			else System.out.println("#" + t + " " + result);
		}
	}
	
	static boolean check(int multi) {
		String num = String.valueOf(multi);
		
		for(int i=0; i<num.length()-1; i++) {
			if(num.charAt(i)-'0' > num.charAt(i+1)-'0') return false;
		} 
		return true;
	}
}