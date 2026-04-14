import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N + 1]; // 1부터 시작

		findNum(1, 0);
	}

	// idx : 현재 인덱스, select : 선택한 인덱스
	static void findNum(int idx, int select) {
		if (select == M) {
			for (int i = 1; i < N+1; i++) {
				if (visited[i])
					System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		if (idx > N)
			return;
		
		visited[idx] = true;
		findNum(idx+1, select+1);
		visited[idx] = false;
		findNum(idx+1, select);
	}
}