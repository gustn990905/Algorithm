import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        for(int i=B.length()-1; i>=0; i--) {
        	System.out.println(Integer.parseInt(A) * (B.charAt(i) - '0'));
        }
        System.out.println(Integer.parseInt(A) * Integer.parseInt(B));
    }
}
