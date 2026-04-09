import java.util.Scanner;

public class Main {
	
	static char[][] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		result = new char[N][N];
		
		StringBuilder sb = new StringBuilder();
		
		star(0, 0, N);
		
		// 결과 출력
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(result[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void star(int x, int y, int size) {
		if(size == 1) { 
			result[x][y] = '*';
			return;
		}
		
		int newSize = size / 3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// 공백 부분
				if(i==1 && j==1) {
					fillBlank(x + i*newSize, y + j*newSize, newSize);
				} else {
					star(x + i*newSize, y+j*newSize, newSize);
				}
			}
		}
	}
	
	static void fillBlank(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				result[i][j] = ' ';
			}
		}
	}
}
