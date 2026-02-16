import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 각 달의 날짜 수
		int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int t=1; t<=T; t++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
						
			// 같은 달인 경우
			if(m1 == m2) {
				System.out.println("#" + t +" " + (d2-d1+1));
			} 
			// 다른 달인 경우
			else {
				// 시작 달에서 남은 날짜 계산
				int result = day[m1-1] - d1;
				
				// 시작 달과 끝 달 사이의 전체 달 더하기
				for(int m=m1+1; m<m2; m++) {
					result += day[m-1];
				}
				// 마지막 달 날짜 더하기
				System.out.println("#" + t + " " + (result+d2+1));
			}
		}
	}
}