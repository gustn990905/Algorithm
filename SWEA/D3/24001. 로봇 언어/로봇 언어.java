import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String line = sc.next();
			
			// 문자열을 문자 배열로 변환
			char[] arr = new char[line.length()];
			
			for(int i=0; i<line.length(); i++) {
				arr[i] = line.charAt(i);
			}
			
			int start = 0; // 시작 위치 (항상 0)
			int robot = 0; // 현재 로봇 위치
			int result = 0; // 현재 이동 후 시작점과의 거리
			int maxResult = Integer.MIN_VALUE; // 최대 거리 저장
			
			// '?'를 모두 'L'로 가정하는 경우
			robot = start;
			for(int i=0; i<line.length(); i++) {
				if(arr[i] == 'L') {
					robot -= 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				} else if(arr[i] == 'R') {
					robot += 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				} else {
					robot -= 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				}
			}
			
			// '?'를 모두 'R'로 가정하는 경우
			robot = start;
			for(int i=0; i<line.length(); i++) {
				if(arr[i] == 'L') {
					robot -= 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				} else if(arr[i] == 'R') {
					robot += 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				} else {
					robot += 1;
					result = Math.abs(robot-start);
					maxResult = Math.max(maxResult, result);
				}
			}
			
			System.out.println(maxResult);
		}
	}
}