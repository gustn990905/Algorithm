import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			// 나누어 떨어지면 값 추가
			if (arr[i] % divisor == 0)
				list.add(arr[i]);
		}

		int size = list.size();

		if (size != 0) {
			int[] answer = new int[size];
			for (int i = 0; i < size; i++) {
				answer[i] = list.get(i);
			}
			Arrays.sort(answer);
			return answer;
		}
		return new int[] { -1 };
	}
}