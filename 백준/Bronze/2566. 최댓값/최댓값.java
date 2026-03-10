import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] arr = new int[9][9];
        int maxNum = 0;
        int maxR = 0;
        int maxC = 0;
        
        for(int r=0; r<9; r++) {
        	for(int c=0; c<9; c++) {
        		arr[r][c] = sc.nextInt();
        		if(arr[r][c] >= maxNum) {
        			maxNum = arr[r][c];
        			maxR = r + 1;
        			maxC = c + 1;
        		}
        	}
        }
        System.out.println(maxNum);
        System.out.println(maxR + " " + maxC);
    }
}