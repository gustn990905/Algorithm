import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for(int t=1; t<=T; t++) {
        	int X = sc.nextInt();
        	int Y = sc.nextInt();
        	int Z = sc.nextInt();
        	
        	// 세 수가 모두 같은 경우 
        	if(X==Y && Y==Z) {
        		// 그대로 출력
        		System.out.println(X + " " + X + " " + X);
        	} 
        	// 두 수만 같은 경우
        	else if(X==Y || Y==Z || X==Z) {
        		// X와 Y가 같고, 그 값이 Z보다 큰 경우
        		if(X==Y && X>Z) {
        			System.out.println(Z+ " " + X + " " + Z);
    			// Y와 Z가 같고, 그 값이 X보다 큰 경우
        		} else if(Y==Z && Y>X) {
        			System.out.println(X+ " " + X + " " + Z);
    			// X와 Z가 같고, 그 값이 Y보다 큰 경우
        		} else if(X==Z && X>Y) {
        			System.out.println(X+ " " + Y + " " + Y);
    			// 두 수가 같긴 하지만 위 조건에 맞지 않는 경우
                // (예: 같은 값이 더 작거나 조건 불충족)
        		} else {
        			System.out.println(-1+ " " + -1 + " " + -1);
        		}
        	} 
        	// 세 수가 모두 다른 경우
        	else {
    			System.out.println(-1+ " " + -1 + " " + -1);
        	}
        }
    }
}