import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수 입력
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 문자열 개수
			int M = sc.nextInt(); // 각 문자열의 길이

			String[] arr = new String[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.next(); // 문자열 입력
			}

			int result = 0; // 최종 팰린드롬 길이

			boolean[] check = new boolean[N]; // 사용된 문자열인지 체크

			// 1. 서로 뒤집어서 같은 문자열 쌍 찾기
			for (int n = 0; n < N - 1; n++) {
				if (check[n])
					continue; // 이미 사용된 문자열이면 넘어감

				for (int m = n + 1; m < N; m++) {

					if (check[m])
						continue; // 이미 사용된 문자열이면 넘어감

					boolean possible = true; // 뒤집어서 같은지 여부

					// arr[n]과 arr[m]이 서로 reverse 관계인지 확인
					for (int i = 0; i < M; i++) {
						if (arr[n].charAt(i) != arr[m].charAt(M - 1 - i)) {
							possible = false;
							break;
						}
					}

					// 짝이 맞으면 양쪽에 배치 가능
					if (possible) {
						result += 2 * M; // 길이 2M 추가
						check[n] = true; // 사용 처리
						check[m] = true; // 사용 처리
						break; // n은 하나의 짝만 가지면 되므로 종료
					}
				}
			}

			// 2. 가운데에 들어갈 수 있는 팰린드롬 문자열 하나 찾기
			for (int n = 0; n < N; n++) {
				if (check[n])
					continue; // 이미 사용된 문자열이면 넘어감

				String find = arr[n];

				boolean possible = true; // 자기 자신이 팰린드롬인지 확인

				// 문자열의 앞뒤를 비교하여 팰린드롬인지 검사
				for (int f = 0; f < find.length() / 2; f++) {
					if (find.charAt(f) != find.charAt(find.length() - 1 - f)) {
						possible = false;
						break;
					}
				}

				// 팰린드롬이면 중앙에 하나만 추가
				if (possible) {
					check[n] = true; // 사용 처리
					result += M; // 길이 M 추가
					break; // 중앙은 하나만 가능
				}
			}

			// 결과 출력
			System.out.println("#" + t + " " + result);
		}
	}
}