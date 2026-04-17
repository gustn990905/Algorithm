import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 격자판의 크기

			char[][] map = new char[N][N];
			int cnt = 0; // #의 개수 저장

			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for (int c = 0; c < N; c++) {
					map[r][c] = line.charAt(c);

					if (map[r][c] == '#')
						cnt++;
				}
			}

			boolean possible = false;

			int square = 0;

			for (int i = 1; i <= 20; i++) {
				if (i * i == cnt) {
					square = i;
					possible = true;
					break;
				}
			}

			if (!possible)
				System.out.println("#" + t + " " + "no");
			else {

//    			boolean found = false;

				loop: for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] == '#') {

//    						if(found) continue; // 이미 검사했으면 넘어감
//    			            found = true;

							for (int i = r; i < r + square; i++) {
								for (int j = c; j < c + square; j++) {

									// 범위를 벗어나면 실패
									if (i < 0 || i >= N || j < 0 || j >= N) {
										possible = false;
										break loop;
									}

									// 범위에 #이 없으면 실패
									if (map[i][j] != '#') {
										possible = false;
										break loop;
									}

									else {
										cnt--;
									}
								}
							}
							if (cnt == 0) {
								break loop;
							} else {
								possible = false;
								break loop;
							}
						}
					}
				}
				if (!possible)
					System.out.println("#" + t + " " + "no");
				else {
					if (cnt == 0)
						System.out.println("#" + t + " " + "yes");
					else
						System.out.println("#" + t + " " + "no");
				}
			}
		}
	}
}