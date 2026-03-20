import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int[] money = {25, 10, 5, 1}; // 쿼터, 다임, 니켈, 페니
    	int[] result = new int[4]; // 결과를 포함할 리스트
    	
    	int T = sc.nextInt();
    	for(int t=1; t<=T; t++) {
    		int C = sc.nextInt();
    		
    		for(int m=0; m<4; m++) {
    			result[m] = C / money[m]; // 줄 수 있는 최대값을 주기 위해 몫 저장
    			
    			C = C % money[m];
    		}
    		
    		for(int m=0; m<4; m++) {
    			System.out.print(result[m] + " ");
    		}
    		System.out.println();
    	}
    }
}