import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String N = sc.next();
    	int num = Integer.parseInt(N);
    	int B = sc.nextInt();
    	
    	String result = Integer.toString(num, B);
    	System.out.println(result.toUpperCase());
    }
}