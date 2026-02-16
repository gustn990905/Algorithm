import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String cal = sc.next();
			
			// 문자열 인덱스를 이용하여 연, 월, 일 분리
			String year = cal.substring(0, 4);
			String month = cal.substring(4, 6);
			String day = cal.substring(6);
			
			// 월 범위 체크 (1~12)
			if(Integer.parseInt(month)<=0 || Integer.parseInt(month)>12) {
				System.out.println("#" + t + " " + -1);
			} else {
				// 월에 따른 일(day) 범위 검사 - 31일까지 있는 달
				if(Integer.parseInt(month) == 1 || Integer.parseInt(month) == 3 || Integer.parseInt(month) == 5 || Integer.parseInt(month) == 7 || Integer.parseInt(month) == 8 || Integer.parseInt(month) == 10 || Integer.parseInt(month) == 12) {
					if(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31) {
						System.out.println("#" + t + " " + year + "/" + month + "/" + day);
					} else {
						System.out.println("#" + t + " " + -1);
					}
				} else if(Integer.parseInt(month) == 4 || Integer.parseInt(month) == 6 || Integer.parseInt(month) == 9 || Integer.parseInt(month) == 11) {
					// 월에 따른 일(day) 범위 검사 - 30일까지 있는 달
					if(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 30) {
						System.out.println("#" + t + " " + year + "/" + month + "/" + day);
					} else { 
						System.out.println("#" + t + " " + -1);
					}
				} else {
					// 월에 따른 일(day) 범위 검사 - 2월 처리
					if(Integer.parseInt(month) == 2) {
						if(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 28) {
							System.out.println("#" + t + " " + year + "/" + month + "/" + day);
						} else { 
							System.out.println("#" + t + " " + -1);
						}
					}
				}
			}
		}
	}
}