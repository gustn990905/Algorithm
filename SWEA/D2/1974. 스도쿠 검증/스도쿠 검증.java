import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[][] map = new int[9][9];

			for (int r = 0; r < 9; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 9; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			boolean possible = true; // 스도쿠 조건 만족 여부

			// 행 검사
			loop: 
				for (int r = 0; r < 9; r++) {
				boolean[] check = new boolean[9];
				for (int c = 0; c < 9; c++) {
					// 숫자가 처음 등장
					if (!check[map[r][c]-1])
						check[map[r][c]-1] = true;

					// 같은 숫자 등장
					else {
						possible = false;
						break loop;
					}
				}
			}

			// 열 검사
			if (possible) {
				loop2: 
					for (int c = 0; c < 9; c++) {
					boolean[] check = new boolean[9];
					for (int r = 0; r < 9; r++) {
						// 숫자가 처음 등장
						if (!check[map[r][c]-1])
							check[map[r][c]-1] = true;

						// 같은 숫자 등장
						else {
							possible = false;
							break loop2;
						}
					}
				}
			}
			
			// 3x3 검사
			if(possible) {
				loop3:
				for(int r=0; r<9; r+=3) {
					for(int c=0; c<9; c+=3) {
						boolean[] check = new boolean[9];
						for(int i=r; i<r+3; i++) {
							for(int j=c; j<c+3; j++) {
								// 숫자가 처음 등장
								if (!check[map[i][j]-1])
									check[map[i][j]-1] = true;

								// 같은 숫자 등장
								else {
									possible = false;
									break loop3;
								}
							}
						}
					}
				}
			}
			if(possible) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
		}
	}
}