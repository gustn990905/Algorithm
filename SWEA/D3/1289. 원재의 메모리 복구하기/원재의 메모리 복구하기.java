import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			String memory = sc.next(); // 목표 메모리 상태 (문자열로 입력)
			int memorySize = memory.length();
			
			int[] finalMemory = new int[memorySize];
			int[] originMemory = new int [memorySize]; // 초기화 상태
			
			for(int i=0; i<memorySize; i++) {
				originMemory[i] = 0; // 초기 메모리의 상태는 모두 0
				finalMemory[i] = memory.charAt(i) - '0'; // 문자 '0' 또는 '1'을 숫자로 변환
			}
			
			int result = 0; // 수정 횟수
			
			// 다른 만큼 수정될 것이므로 다르면 result++
			for(int i=0; i<memorySize; i++) {
				if(originMemory[i] != finalMemory[i]) {
					result++;
					
					// 현재 값에 따라 뒤를 모두 반전
					if(originMemory[i] == 1) {
						for(int j=i; j<memorySize; j++) {
							originMemory[j] = 0; // i부터 끝까지 0으로 변경
						}
					} else {
						for(int j=i; j<memorySize; j++) {
							originMemory[j] = 1; // i부터 끝까지 1로 변경
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}