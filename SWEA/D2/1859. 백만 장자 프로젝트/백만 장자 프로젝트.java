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
			
			long result = 0; // 최대 이익 저장 변수
			int maxCost = 0; // 뒤에서부터 확인할 때의 최대 가격
			for(int n=N-1; n>=0; n--) { // 뒤에서부터 탐색(미래의 최고 가격을 기준으로 계산)
				maxCost = Math.max(maxCost, arr[n]); // 현재까지의 최대 가격 갱신
				if(arr[n] < maxCost) { // 현재 가격이 미래 최대 가격보다 작다면 오늘 1개 구매 후 미래 최대 가격에 판매
					result += maxCost - arr[n]; // 차익만큼 이익 누적
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}