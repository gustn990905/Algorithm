import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num = sc.next();
		
		int result = 0;
		for(int n=0; n<num.length(); n++) {
			char find = num.charAt(n);;
			
			if(find == 'A' || find == 'B' || find=='C') {
				result += 3;
			} else if(find == 'D' || find == 'E' || find=='F') {
				result += 4;
			} else if(find == 'G' || find == 'H' || find=='I') {
				result += 5;
			} else if(find == 'J' || find == 'K' || find=='L') {
				result += 6;
			} else if(find == 'M' || find == 'N' || find=='O') {
				result += 7;
			} else if(find == 'P' || find == 'Q' || find=='R' || find=='S') {
				result += 8;
			} else if(find == 'T' || find == 'U' || find=='V') {
				result += 9;
			} else {
				result += 10;
			}
		}
		
		System.out.println(result);
	}
}