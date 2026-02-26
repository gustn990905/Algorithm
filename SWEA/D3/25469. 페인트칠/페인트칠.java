import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			String num = br.readLine();
			String[] num2 = num.split(" ");
			
			int H = Integer.parseInt(num2[0]);
			int W = Integer.parseInt(num2[1]);
			
			char[][] arr = new char[H][W];
			
			// 배열 입력 받기
			for(int r=0; r<H; r++) {
				String line = br.readLine();
				for(int c=0; c<W; c++) {
					// 한 줄의 각 문자를 배열에 저장
					arr[r][c] = line.charAt(c);
				}
			}
			
			int resultR = 0; // '#'로만 이루어진 행 개수
			int resultC = 0; // '#'로만 이루어진 열 개수
			
			// 행 검사
			for(int r=0; r<H; r++) {
				boolean right = true;
				for(int c=0; c<W; c++) {
					// 하나라도 '#'이 아니면 false
					if(arr[r][c] != '#') {
						right = false;
						break;
					}
				}
				// 전부 '#'이면 카운트 증가
				if(right) {
					resultR++;
				}
			}
			
			// 열 검사
			for(int c=0; c<W; c++) {
				boolean right = true;
				for(int r=0; r<H; r++) {
					if(arr[r][c] != '#') {
						right = false;
						break;
					}
				}
				if(right) {
					resultC++;
				}
			}
			
			// 모든 행과 열이 전부 '#'인 경우
			if(resultR == H && resultC==W) {
				// 최소 연산 횟수는 행 전체를 칠하는 경우(H번)
				// 또는 열 전체를 칠하는 경우(W번)
				// 둘 중 더 작은 값이 최소 연산
				if (H<=W) {
					System.out.println(H);
				} else {
					System.out.println(W);
				}
			} 
			
			// 그 외의 경우:
			// 전부 '#'인 행 개수 + 전부 '#'인 열 개수 출력
			else {
				System.out.println(resultR + resultC);
			}
		}
	}
}