import java.util.Scanner;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // 출력할 '#'의 개수 입력
		
		for(int n=0; n<num; n++) { // 입력받은 수(num)만큼 반복하면서'#' 문자를 연속 출력
			System.out.print("#");
		}
	}
}