import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = 1; // 약수의 시작은 1
			int sum = 0;

			List<Integer> list = new ArrayList<>();

			int n = sc.nextInt(); // 완전수인지 판별할 숫자 입력

			if (n == -1)
				break; // 입력의 마지막에는 -1이 주어짐

			// 자기 자신을 제외한 모든 약수들의 합과 같아야 하니까 n보다는 작을 때 까지
			while (num < n) {
				if (n % num == 0) {
					sum += num;
					list.add(num);
				}

				num++;
			}

			if (sum == n) {
				System.out.print(n + " = ");

				for (int i = 0; i < list.size() - 1; i++) {
					System.out.print(list.get(i) + " + ");
				}

				System.out.print(list.get(list.size() - 1));
				System.out.println();
			} else
				System.out.println(n + " is NOT perfect.");
		}
	}
}