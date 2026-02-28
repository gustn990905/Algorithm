import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			String S = sc.next();
			int size = S.length();

			char[] arr = new char[size]; // 문자 하나씩 저장할 배열
			boolean[] cor = new boolean[size]; // 짝이 맞았는지 체크할 배열
			boolean result = true; // 최종 결과 판단 변수
			int[] count = new int[10];

			for (int i = 0; i < size; i++) {
				arr[i] = S.charAt(i);
			}

			
			for(int i=0; i<size; i++) {
				count[arr[i] - '0']++;
			}
			
			// 각 인덱스를 순회하면서 점프 위치 확인
			for (int i = 0; i < size; i++) {
				// 이미 짝이 맞은 위치라면 건너뜀
				if (cor[i]) {
					continue;
				}

				int num = arr[i] - '0'; // 현재 문자를 숫자로 변환
				int next = i + num + 1; // 점프할 다음 위치 계산

				// 점프 위치가 문자열 범위를 벗어나면 실패
				if (next >= size || arr[i] != arr[next] || cor[next]) {
					result = false;
					break;
				}
				// 현재 위치와 점프 위치가 모두 아직 사용되지 않았고
				// 두 값이 같다면 짝으로 처리
				if (!cor[i] && !cor[next] && arr[i] == arr[next]) {
					cor[i] = true;
					cor[next] = true;
				} else {
					result = false;
					break;
				}
			}

			// 모든 위치가 짝 처리 되었는지 최종 확인
			for (int i = 0; i < size; i++) {
				if (!cor[i]) {
					result = false;
					break;
				}
			}
			
			for(int i=0; i<10; i++) {
				if(count[i]!=0 && count[i]!=2) {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}