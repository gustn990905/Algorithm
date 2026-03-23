import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] square = new int[3][2];
		int[] check1 = new int[1001];
		int[] check2 = new int[1001];
		
		for(int i=0; i<3; i++) {
			square[i][0] = sc.nextInt();
			square[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<3; i++) {
			check1[square[i][0]]++;
			check2[square[i][1]]++;
		}
		
		for(int i=0; i<=1000; i++) {
			if(check1[i] == 1) {
				System.out.print(i + " ");
				break;
			}
		}
		
		for(int i=0; i<=1000; i++) {
			if(check2[i] == 1) {
				System.out.print(i);
				break;
			}
		}
	}
}