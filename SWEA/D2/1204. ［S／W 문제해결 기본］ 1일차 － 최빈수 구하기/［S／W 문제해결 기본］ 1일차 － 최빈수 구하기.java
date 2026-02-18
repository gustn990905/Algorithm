import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int testCase = sc.nextInt();
			
			// 점수 빈도 저장 배열 (0~100점)
			// 인덱스 = 점수, 값 = 해당 점수를 받은 사람 수
			int[] score = new int[101];
			
			for(int s=0; s<1000; s++) {
				// 입력받은 점수의 개수 1 증가 
				score[sc.nextInt()]++;
			}
			
			// 가장 많이 나온 점수의 "횟수" 찾기
			int maxScoreCount = 0;
			for(int m=0; m<score.length; m++) {
				maxScoreCount = Math.max(maxScoreCount, score[m]);
			}

			// 최빈 점수 저장 변수
			int maxScore = 0;
			
			// 높은 점수부터 역순 탐색
			// (동점일 경우 더 큰 점수를 선택하기 위함)
			for(int m=score.length-1; m>=0; m--) {
				if(score[m] == maxScoreCount) {
					maxScore = m;
					break; // 찾았으면 종료
				}
			}
			System.out.println("#" + testCase + " " + maxScore);
		}
	}
}