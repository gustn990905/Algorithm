import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n=0; n<N; n++) {
			String way = sc.next();
			
			// 방문 체크
			// 북:0, 서:1, 남:2, 동:3
			int[] check = new int[4];
			
			for(int w=0; w<way.length(); w++) {
				if(way.charAt(w) == 'N') check[0]++;
				else if(way.charAt(w) == 'W') check[1]++;
				else if(way.charAt(w) == 'S') check[2]++;
				else check[3]++;
			}
			
			if(check[0] > 0 && check[2] > 0 && check[1]>0 && check[3]>0) System.out.println("Yes");
			else if(check[0] > 0 && check[2] > 0 && check[1]==0 && check[3]==0) System.out.println("Yes");
			else if(check[1] > 0 && check[3] > 0 && check[0]==0 && check[2]==0) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}