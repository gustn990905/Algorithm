import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] tree;   // 각 노드의 왼쪽, 오른쪽 자식 번호를 저장하는 배열
	static String[] data;  // 각 노드에 저장된 값(연산자 또는 숫자)을 저장하는 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 10개 반복
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine()); // 노드 개수 입력

			tree = new int[N + 1][2]; // 1번 인덱스부터 사용하기 위해 N+1 크기로 생성
			data = new String[N + 1]; // 각 노드의 데이터를 저장할 배열

			// 각 노드 정보 입력
			for (int n = 0; n < N; n++) {
				String[] line = br.readLine().split(" ");

				// 길이가 4라면: [노드번호, 연산자, 왼쪽자식, 오른쪽자식]
				if (line.length == 4) {
					int idx = Integer.parseInt(line[0]);  // 현재 노드 번호
					data[idx] = line[1];                  // 연산자 저장
					tree[idx][0] = Integer.parseInt(line[2]); // 왼쪽 자식 노드 번호
					tree[idx][1] = Integer.parseInt(line[3]); // 오른쪽 자식 노드 번호
				} 
				// 길이가 2라면: [노드번호, 숫자] -> 리프 노드
				else {
					int idx = Integer.parseInt(line[0]);  // 현재 노드 번호
					data[idx] = line[1];                  // 숫자 저장
				}
			}
			
			// 루트 노드(1번)부터 계산 시작
			System.out.println("#" + t + " " + cal(1));
		}
	}
	
	// num번 노드를 루트로 하는 서브트리 계산 함수
	public static int cal(int num) {
		// 노드 번호가 0이면 (존재하지 않는 경우) 0 반환
		if(num == 0) return 0;
		
		// 왼쪽, 오른쪽 자식이 모두 0이면 -> 리프 노드 (숫자 노드)
		if(tree[num][0] == 0 && tree[num][1] == 0) {
			return Integer.parseInt(data[num]); // 문자열 숫자를 정수로 변환하여 반환
		}
		
		// 왼쪽 서브트리 계산
		int left = cal(tree[num][0]);
		// 오른쪽 서브트리 계산
		int right = cal(tree[num][1]);
		
		// 현재 노드에 저장된 연산자에 따라 계산 수행
		switch(data[num]) {
			case "+" : return left + right;   // 덧셈
			case "-" : return left - right;   // 뺄셈
			case "*" : return left * right;   // 곱셈
			default : return left / right;    // 나눗셈
		}
	}
}