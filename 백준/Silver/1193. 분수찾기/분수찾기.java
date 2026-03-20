import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int line = 1;
        int sum = 0;

        while (sum + line < X) {
            sum += line;
            line++;
        }

        int offset = X - sum;

        int numerator, denominator;

        if (line % 2 == 0) {
            numerator = offset;
            denominator = line - offset + 1;
        } else {
            numerator = line - offset + 1;
            denominator = offset;
        }

        System.out.println(numerator + "/" + denominator);
    }
}