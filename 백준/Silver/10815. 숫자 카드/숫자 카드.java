import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] card1 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			card1[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card1);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(binarySearch(card1, target)) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static boolean binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right){
			int mid = (right+left) / 2;
			
			if(arr[mid] == target) return true;
			else if(arr[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return false;
	}
}