import java.util.Scanner;

public class Solution {

	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // 원소의 개수
			int m = sc.nextInt(); // 연산의 개수
			
			StringBuilder sb = new StringBuilder();
			
			parent = new int[n+1]; // 원소가 1번부터 시작
			for(int p=1; p<=n; p++) {
				parent[p] = p;
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int i=0; i<m; i++) {
				int c = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(c == 0) {
					int rootA = find(a);
					int rootB = find(b);
					
					if(rootA != rootB) parent[rootA] = rootB;
				} else {
					int rootA = find(a);
					int rootB = find(b);
					
					if(rootA == rootB) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}
	
	static int find(int v) {
		if(v != parent[v]) parent[v] = find(parent[v]);
		return parent[v];
	}
}
