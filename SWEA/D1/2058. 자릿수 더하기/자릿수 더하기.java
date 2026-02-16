import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 숫자를 문자열 형태로 입력받음(각 자릿수를 개별적으로 처리하기 위함)
		String N = sc.next();
		
		int result = 0;
		for(int n=0; n<N.length(); n++) {
			result += N.charAt(n) - '0'; // charAt(n)으로 한 자리 문자 추출
			// '0'을 빼주면 해당 문자의 정수 값으로 변환됨
		}
		System.out.println(result);
	}
}