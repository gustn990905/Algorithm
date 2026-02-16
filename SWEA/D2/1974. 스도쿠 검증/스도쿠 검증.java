import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] puzzle = new int[9][9];
			// 스도쿠가 올바른지 판단할 변수
			boolean pass = true;
			
			// 스도쿠 입력 받기
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					puzzle[r][c] = sc.nextInt();
				}
			}
			
			// 가로 검사
			for(int r=0; r<9&&pass; r++) {
				// 숫자 1~9 등장 횟수 저장 배열
				int[] count = new int[9];
				for(int c=0; c<9&&pass; c++) {
					// 숫자 1~9를 인덱스 0~8로 맞추기 위해 -1
					count[puzzle[r][c] - 1]++;
				}
				for(int k=0; k<9; k++) {
					// 모든 숫자가 정확히 1번씩 등장해야 함
					if(count[k] != 1) {
						pass = false;
					}
				}
			}
			
			// 세로 검사
			for(int c=0; c<9&&pass; c++) {
				int[] count = new int[9];
				for(int r=0; r<9&&pass; r++) {
					count[puzzle[r][c] - 1]++;
				}
				for(int k=0; k<9; k++) {
					if(count[k] != 1) {
						pass = false;
					}
				}
			}
			
			// 3x3 박스 검사
			// 3칸씩 이동하면서 9개의 작은 박스 검사
			for(int r=0; r<9&&pass; r+=3) {
				for(int c=0; c<9&&pass; c+=3) {
					int[] count = new int[9];
					for(int r1=r; r1<r+3; r1++) {
						for(int c1=c; c1<c+3; c1++) {
							count[puzzle[r1][c1] - 1]++;
						}
					}
					for(int k=0; k<9; k++) {
						if(count[k] != 1) {
							pass = false;
						}
					}
				}
			}
			
			if(pass) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}
}