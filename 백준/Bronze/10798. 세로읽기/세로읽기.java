import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] line = new String[5];

		int max = 0;

		for (int i = 0; i < 5; i++) {
			line[i] = sc.next();
			max = Math.max(max, line[i].length());
		}

		for(int j=0; j<max; j++) {
            for(int i=0; i<5; i++) {

                if(line[i].length() <= j) {
                    continue;
                }

                System.out.print(line[i].charAt(j));
            }
        }
    }
}