import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(int i=2; i>=0; i--) {
        	a.append(A.charAt(i));
            b.append(B.charAt(i));
        }
        if(Integer.parseInt(a.toString()) > Integer.parseInt(b.toString())) {
        	System.out.println(a);
        } else {
        	System.out.println(b);
        }
    }
}