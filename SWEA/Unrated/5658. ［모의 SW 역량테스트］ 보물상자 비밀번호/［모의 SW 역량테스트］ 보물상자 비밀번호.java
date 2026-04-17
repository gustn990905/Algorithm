import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 입력되는 수의 개수
			int K = sc.nextInt(); // K번째로 큰 수

			String str = sc.next();

			Set<Integer> result = new HashSet<>();

			int size = N / 4;
			
			// size만큼 문자열 수정
			for(int i=0; i<size; i++) {
				// 구간 4개로 나누기
				for(int j=0; j<4; j++) {
					String part = str.substring(j*size, (j+1)*size);
					result.add(Integer.parseInt(part, 16));
				}
				
				str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
			}
			
			List<Integer> resultList = new LinkedList<>(result);
			
			Collections.sort(resultList, Collections.reverseOrder());
			
			System.out.println("#" + t + " " + resultList.get(K-1));
		}
	}
}