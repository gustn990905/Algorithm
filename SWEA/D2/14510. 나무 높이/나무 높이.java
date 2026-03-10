import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] tree = new int[N];

			int maxTree = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
				if (tree[i] > maxTree) {
					maxTree = tree[i];
				}
			}

			// 모든 나무를 가장 높은 나무 높이까지 키우기 위해 필요한 성장량 계산
			for (int i = 0; i < N; i++) {
				tree[i] = maxTree - tree[i];
			}
			
			Arrays.sort(tree);

			int day = 0;

			// 이미 성장 필요량이 0인 나무 개수 확인
			int finish = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] == 0) {
					finish++;
				}
			}

			while (true) {
				Arrays.sort(tree); // 매 반복마다 정렬하여 가장 큰 성장량을 뒤로 보냄
				
				// 성장 완료된 나무 개수 갱신
				for (int i = finish; i < N; i++) {
					if (tree[i] == 0) {
						finish++;
					}
				}
				
				// 모든 나무가 목표 높이에 도달하면 종료
				if (finish == N)
					break;

				day++;

				// 홀수날 -> 물 1 만큼 성장 가능
				if (day % 2 == 1) {
					boolean possible = false; // 성장 가능한 나무 찾았는지 여부
					for (int i = finish; i < N; i++) {
						// 성장 필요량이 2이면 짝수날에 처리하기 위해 건너뜀
						if (tree[i] == 2)
							continue;
						
						// 홀수 성장량이면 1을 빼서 처리
						if (tree[i] % 2 == 1) {
							possible = true;
							tree[i] -= 1;
							break;
						}
					}
					
					// 적절한 나무를 못 찾으면 가장 큰 나무에서 1 감소
					if (!possible) {
						if (tree[N - 1] > 2) {
							tree[N - 1] -= 1;
						}
					}

				} 
				// 짝수날 -> 물 2 만큼 성장 가능
				else {
					boolean possible = false;
					for (int i = finish; i < N; i++) {
						// 성장 필요량이 2 이상이고 짝수이면 처리
						if (tree[i] >= 2) {
							if (tree[i] % 2 == 0) {
								possible = true;
								tree[i] -= 2;
								break;
							}
						}
					}
					
					// 적절한 나무가 없으면 가장 큰 나무에서 2 감소
					if (!possible) {
						if (tree[N - 1] > 1) {
							tree[N - 1] -= 2;
						}
					}
				}
			}
			System.out.println("#" + t + " " + day);
		}
	}
}