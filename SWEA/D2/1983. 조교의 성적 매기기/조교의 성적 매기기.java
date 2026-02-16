import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		// 등급 배열 (하위 -> 상위 순)
		String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] student = new int[N][3];
			double[] score = new double[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					student[i][j] = sc.nextInt();
				}
				score[i] = student[i][0]*0.35 + student[i][1]*0.45 + student[i][2]*0.2;
			}
			// K번째 학생의 점수 저장 (인덱스는 K-1)
			double kScore = score[K-1];
			
			Arrays.sort(score);
			int gradeNum = 0;
			
			// 정렬된 배열에서 K 학생 점수의 위치 찾기
			for(int i=0; i<N; i++) {
				if(kScore == score[i]) {
					gradeNum = i;
					break;
				}
			}
			/*
			 * 전체 학생을 10등분
			 * gradeNum / (N/10) -> 등급 구간 계산
			 */
			System.out.println("#" + t + " " + grade[gradeNum/(N/10)]);
		}
	}
}