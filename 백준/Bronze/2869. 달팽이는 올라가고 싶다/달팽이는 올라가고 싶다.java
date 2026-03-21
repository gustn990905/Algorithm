import java.util.Scanner;
public class Main {
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt(); // 달팽이가 올라갈 갈 수 있는 높이
        int B = sc.nextInt(); // 달팽이가 미끄러지는 높이
        int V = sc.nextInt(); // 나무의 높이
        
        int day = (V - A) / (A - B);

        if ((V - A) % (A - B) != 0) {
            day++;
        }

        day++; // 마지막 날

        System.out.println(day);
    }
}