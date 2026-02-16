import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int n=1; n<=N; n++) {
			// 현재 숫자를 문자열로 변환 (각 자리 확인하기 위해)
			String num = Integer.toString(n);
			// 3, 6, 9의 개수를 저장할 변수
			int count = 0;
			
			for(int i=0; i<num.length(); i++) {
				// 해당 자리가 3, 6, 9라면 count 증가
				if(num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
					count++;
				}
			}
			// 3,6,9가 하나도 없으면 숫자 그대로 출력
			// 하나 이상 있으면 개수만큼 '-' 출력
			if(count == 0) {
				System.out.print(n + " ");
			} else {
				for(int j=0; j<count; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}
}