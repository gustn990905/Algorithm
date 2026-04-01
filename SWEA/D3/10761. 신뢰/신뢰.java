import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 수
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 버튼의 수
			
			// B인지 O인지 저장
			Queue<String> robot = new LinkedList<>();
			
			// 누를 버튼의 수
			Queue<Integer> move = new LinkedList<>();
			
			for(int n=0; n<N; n++) {
				robot.add(sc.next());
				move.add(sc.nextInt());
			}
			
			int count = 0;
			int bPlace = 1;
			int oPlace = 1;
			int bTime = 0;
			int oTime = 0;
			
			// 로봇이 버튼을 모두 누르면 끝
			while(!robot.isEmpty()) {
				String targetRobot = robot.poll();
				int target = move.poll();
				
				// 파란 로봇이 버튼을 누르는 경우
				if(targetRobot.equals("B")) {
					
					// 현재 위치와 버튼의 위치의 차
					int moveTime = Math.abs(target - bPlace);
					
					// 현재 파란 로봇의 누적 시간에 moveTime 더하기
					int arriveTime = bTime + moveTime;
					
					// 현재까지의 시간과 파란 로봇의 누적 시간을 비교해서 더 큰 값 찾기
					// 현재까지의 누적 시간인 count가 더 큰 경우 이미 도착해서 기다리는중
					// 버튼을 누르는 시간인 1 더하기
					count = Math.max(count, arriveTime) + 1;
					
					bTime = count;
					bPlace = target;
				} 
				
				// 오렌지 로봇의 이동도 블루 로봇과 똑같이 동작
				else {
					int moveTime = Math.abs(target - oPlace);
					int arriveTime = oTime + moveTime;
					
					count = Math.max(arriveTime, count) + 1;
					
					oTime = count;
					oPlace = target;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}