import java.util.Scanner;

public class Solution {
	
	static int[] gyu;
	static int[] in;
	static boolean[] gyuCard; // 규영이가 가진 카드 번호 체크 (1~18)
	static boolean[] visited; // 인영이 카드 순열을 만들 때 사용한 카드 체크
	static int gyuScore;
	static int inScore;
	static int gyuWin;
	static int gyuLose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			gyu = new int[9];
			in = new int[9];
			
			gyuCard = new boolean[19];
			visited = new boolean[9];
			
			// 규영이 카드 9장 입력
			for(int g=0; g<9; g++) {
				int card = sc.nextInt();
				gyu[g] = card; // 규영 카드 저장
				gyuCard[card] = true; // 해당 카드 번호 체크
			}
			
			// 전체 카드(1~18) 중 규영 카드 제외하고 인영 카드 생성
			int i = 0;
			for(int c=1; c<=18; c++) {
				if(!gyuCard[c]) {
					in[i++] = c;
				}
			}
			
			// 점수 초기화
			gyuScore = 0;
			inScore = 0;
			
			// 승패 횟수 초기화
			gyuWin = 0;
			gyuLose = 0;
			 
			// DFS 시작 (0번째 라운드부터)
			score(0);
			
			System.out.println("#" + t + " " + gyuWin + " " + gyuLose);
		}
	}
	
	public static void score(int idx) {
		// 9라운드를 모두 진행한 경우
		if(idx == 9) {
			// 점수 비교 후 승패 결정
			if(gyuScore > inScore) {
				gyuWin++;
				return;
			} else if(gyuScore == inScore) {
				return;
			} else {
				gyuLose++;
				return;
			}
		}
		
		// 인영 카드 순열 생성
		for(int i=0; i<9; i++) {
			// 이미 사용한 카드면 건너뜀
			if(visited[i]) continue;
			
			visited[i] = true;
			
			// 현재 라운드 카드 비교
			if(gyu[idx] > in[i]) {
				gyuScore += gyu[idx] + in[i];
			} else {
				inScore += gyu[idx] + in[i];
			}
			
			score(idx+1);
			
			// 백트래킹: 점수 원상복구
			if(gyu[idx] > in[i]) {
				gyuScore -= gyu[idx] + in[i];
			} else {
				inScore -= gyu[idx] + in[i];
			}
			
			visited[i] = false;
		}
	}
}