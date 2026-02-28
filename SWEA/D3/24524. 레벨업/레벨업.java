import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	int minResult = Integer.MAX_VALUE;
        	
        	for(int n=0; n<N; n++) {
        		arr[n]= sc.nextInt();
        	}
        	
        	// 2번 ~ N-1번 체크포인트 중 하나를 건너뛰는 경우를 모두 시도
            // (인덱스 1 ~ N-2)
        	for(int n=1; n<N-1; n++) {
        		int result = 0;
        		
        		for(int i=0; i<N-1; i++) {
        			int start = i;
        			int end = i+1;
        			
        			// 만약 현재 위치가 건너뛸 체크포인트라면
                    // 이 구간은 계산하지 않고 넘어감
        			if(start == n) {
        				continue;
        			}
        			
        			// 만약 다음 위치가 건너뛸 체크포인트라면
                    // 그 다음 위치(i+2)로 점프
        			if(end == n) {
        				if(i+2 < N) {
        					end = i+2;
        				} else {
        					continue; // 범위를 벗어나면 스킵
        				}
        			}
        			result += Math.abs(arr[start] - arr[end]);
        		}
        		
        		minResult = Math.min(minResult, result);
        	}
        	
        	System.out.println(minResult);
        }
    }
}