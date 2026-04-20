import java.util.Scanner;

public class Solution {
	
	static int N;
	static String[] operator = {"+", "-", "*", "/"};
	static int[] operatorCnt;
	static int[] num;
	static int operatorCount;
	
	static int maxResult;
	static int minResult;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수 
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt(); // 숫자판의 숫자 개수
			
			operatorCount = 0;
			
			operatorCnt = new int[4];
			
			for(int i=0; i<4; i++) {
				operatorCnt[i] = sc.nextInt(); // 각 연산자의 개수 입력
				operatorCount += operatorCnt[i];
			}
		
			num = new int[N]; // 수식에 사용되는 숫자 배열
			for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
			}
			
			maxResult = Integer.MIN_VALUE;
			minResult = Integer.MAX_VALUE;
			
			findMaxNum(0, num[0]);
			System.out.println("#" + t + " " + (maxResult-minResult));
		}
	}
	
	static void findMaxNum(int idx, int sum) {
		// 모든 연산자를 다 사용한 경우 최댓값, 최솟값 갱신
		if(idx == operatorCount) {
		    maxResult = Math.max(maxResult, sum);
		    minResult = Math.min(minResult, sum);
		    return;
		}
		
		// 0번은 +, 1번은 -, 2번은 *, 3번은 /
		for(int i=0; i<4; i++) {
			if(operatorCnt[i] > 0) {
				operatorCnt[i]--; // 연산자 하나 사용
				
				int next = cal(sum, idx, i);
				
				findMaxNum(idx+1, next);
				
				operatorCnt[i]++; // 백트래킹
			}
		}
	}
	
	static int cal(int sum, int idx, int i) {
		if(i == 0) return sum + num[idx+1];
		if(i == 1) return sum - num[idx+1];
		if(i == 2) return sum * num[idx+1];
		else return sum / num[idx+1];
	}
}