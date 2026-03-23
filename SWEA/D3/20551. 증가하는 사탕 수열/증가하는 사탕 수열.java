import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] box = new int[3];
			
			for(int i=0; i<3; i++) {
				box[i] = sc.nextInt();
			}
			
			int eat = 0;
			
			if(box[2] == 1 || box[2] == 2) {
				System.out.println("#" + t + " " + (-1));
				continue;
			}
			
			if(box[0] < box[1] && box[1] <box[2]) {
				System.out.println("#" + t + " " + (0));
				continue;
			}
			
			boolean possible = true;
			if(box[1] >= box[2]) {
				while(box[1] >= box[2]) {
					box[1]--;
					eat++;
					
					if(box[1] == 0) {
						possible = false;
						break;
					}
				}
			}
			
			if(box[0] >= box[1]) {
				while(box[0] >= box[1]) {
					box[0]--;
					eat++;
					
					if(box[0] == 0) {
						possible = false;
						break;
					}
				}
			}
			if(possible) System.out.println("#" + t + " " + eat);
			else System.out.println("#" + t + " " + (-1));
		}
	}
}
