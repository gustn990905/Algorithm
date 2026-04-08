import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		Map<String, Integer> cnt = new HashMap<>();
		
		int sum = 0;
		for(int n=0; n<N; n++) {
			int num = sc.nextInt();
			arr[n] = num;
			sum += arr[n];
			String num2 = String.valueOf(num);
			
			if(cnt.containsKey(num2)) cnt.put(num2, cnt.get(num2)+1);
			else cnt.put(num2, 1);
		}
		
		System.out.println(Math.round((double) sum / N));
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		
		int max = 0;
		for(int n : cnt.values()) {
			max = Math.max(max, n);
		}
		
		int[] modes = new int[cnt.size()];
		int idx = 0;
		
		for(String key : cnt.keySet()) {
			if(cnt.get(key) == max) {
				modes[idx++] = Integer.parseInt(key);
			}
		}
		
		Arrays.sort(modes, 0, idx);

		if (idx > 1) {
		    System.out.println(modes[1]); 
		} else {
		    System.out.println(modes[0]);
		}
		
		System.out.println(arr[N-1] - arr[0]);
	}
}
