import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();
			}
			
			int result = -1;
			
			// 숫자 2개 뽑기
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					
					// 숫자를 하나씩 확인하기 위해서 String으로 변환
					String num = String.valueOf(arr[i]*arr[j]);
					
					boolean possible = true;
					for(int k=0; k<num.length()-1; k++) {
						
						// 다음수가 그 전보다 수 적으면 possible=false로 변경 
						if(num.charAt(k) > num.charAt(k+1)) {
							possible = false;
							break;
						}
					}
					
					if(possible) result = Math.max(result, arr[i]*arr[j]);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}