import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] tree = new int[N];
		for(int n=0; n<N; n++) {
			tree[n] = sc.nextInt();
		}
		
		// 가로수 위치의 간격
		distance = new int[N-1];
		for(int n=1; n<N; n++) {
			distance[n-1] = tree[n] - tree[n-1];
		}
		
		// 입력 값이 여러개인 경우 최대공약수 구하기
		int gcd = gcdAll(distance);
				
		Arrays.sort(tree);
		
		// 전체 가로수 간격
		int totalLength = tree[N-1] - tree[0];
		
		int totalTree = totalLength / gcd + 1;
		
		System.out.println(totalTree - N);
	}
	
	static int gcdAll(int[] arr) {
		int result = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			result = findGCD(result, arr[i]);
		}
		
		return result;
	}
	
	static int findGCD(int a, int b) {
		while(b != 0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
}