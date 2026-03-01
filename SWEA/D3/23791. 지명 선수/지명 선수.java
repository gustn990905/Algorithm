import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] A = new int[N]; // A가 원하는 위치 순서
			int[] B = new int[N]; // B가 원하는 위치 순서
			
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				B[i] = sc.nextInt();
			}
			
			// 최종 결과를 저장할 배열 (1번 인덱스부터 사용하기 위해 N+1)
			// 기본값은 '\u0000' (0)
			char[] result = new char[N+1];
			
			int findA = 0; // A 배열에서 현재 탐색 위치
			int findB = 0; // B 배열에서 현재 탐색 위치
			
			for(int i=1; i<=N; i++) {
				
				// 홀수 턴 -> A 차례
				if(i % 2 == 1) {
					
					// A가 원하는 위치가 비어있다면
					if(result[A[findA]] == 0) {
						result[A[findA]] = 'A'; // 해당 위치에 A 배치
						continue;
					} 
					// 이미 차있다면 다음 원하는 위치를 찾음
					else {
						while(result[A[findA]] != 0) {
							findA++; // 다음 후보 위치로 이동
						}
						result[A[findA]] = 'A'; // 빈 위치에 배치
						continue;
					}
				} 
				
				// 짝수 턴 -> B 차례
				else {
					
					// B가 원하는 위치가 비어있다면
					if(result[B[findB]] == 0) {
						result[B[findB]] = 'B'; // 해당 위치에 B 배치
						continue;
					} 
					
					// 이미 차있다면 다음 원하는 위치를 찾음
					else {
						while(result[B[findB]] != 0) {
							findB++;
						}
						result[B[findB]] = 'B';
						continue;
					}
				}
			}
			
			// 1번 인덱스부터 N번까지 결과 출력
			for(int i=1; i<=N; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}
	}
}