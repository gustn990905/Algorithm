import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int num;
	static int[][] map;
	static List<int[]> zeroList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0)
					zeroList.add(new int[] { r, c });
			}
		}

		findNum(0);
	}

	static void findNum(int idx) {
		if (idx == zeroList.size()) {
			print();
			System.exit(0);
		}

		int r = zeroList.get(idx)[0];
		int c = zeroList.get(idx)[1];

		for (int k = 1; k <= 9; k++) {
			if (possible(r, c, k)) {
				map[r][c] = k;
				findNum(idx + 1);
				map[r][c] = 0;
			}
		}
	}

	static boolean possible(int r, int c, int num) {
		// 가로 검사
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num)
				return false;
		}

		// 세로 검사
		for (int j = 0; j < 9; j++) {
			if (map[j][c] == num)
				return false;
		}

		// 3X3 검사
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}
	
	static void print() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int x : row) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}