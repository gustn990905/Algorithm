import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int S3 = sc.nextInt();
		
		// 나올 수 있는 합의 최댓값은 S1+S2+S3
		// 인덱스를 합으로 사용하기 위해 +1 크기로 배열 생성
		int[] sum = new int[S1+S2+S3+1];
		
		for(int i=1; i<=S1; i++) {
			for(int j=1; j<=S2; j++) {
				for(int k=1; k<=S3; k++) {
					// 세 주사위 눈의 합에 해당하는 인덱스 값 증가
					sum[i+j+k]++;
				}
			}
		}
		
		int maxNum = 0; // 가장 많이 나온 횟수 저장
		int idx = 0;    // 가장 많이 나온 합 저장
		
		// 뒤에서부터 탐색 (큰 수부터 확인)
		for(int n=sum.length-1; n>=0; n--) {
			
			// 현재 합이 더 많이 나왔거나 같은 경우 갱신
			// (>= 이므로 같은 빈도일 때는 더 작은 값으로 최종 갱신됨)	
			if(sum[n]>=maxNum) {
				maxNum = sum[n];
				idx = n;
			}
		}
		
		System.out.println(idx);
	}
}