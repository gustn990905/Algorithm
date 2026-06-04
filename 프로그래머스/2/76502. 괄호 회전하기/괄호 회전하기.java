import java.util.Stack;

class Solution {
	public int solution(String s) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder(s);
		
		// 하나씩 밀어서 확인하기
		for (int k = 0; k < s.length(); k++) {
			if (k != 0) {
				char t = sb.charAt(0);
				sb.deleteCharAt(0);
				sb.append(t);
			}

			Stack<Character> temp = new Stack<>();
			boolean possible = true;
			for (int i = 0; i < sb.length(); i++) {
				if (temp.isEmpty()) {
					// stack이 비어있는데 닫힌 괄호가 들어오면 이미 실패
					if (sb.charAt(i) == '}' || sb.charAt(i) == ']' || sb.charAt(i) == ')') {
						possible = false;
						break;
					} else
						temp.add(sb.charAt(i));
				} else {
					// 열린 괄호면 stack에 넣기
					if (sb.charAt(i) == '{' || sb.charAt(i) == '[' || sb.charAt(i) == '(')
						temp.add(sb.charAt(i));
					else {
						if (temp.peek() == '(' && sb.charAt(i) == ')') {
							temp.pop();
						} else if (temp.peek() == '{' && sb.charAt(i) == '}') {
							temp.pop();
						} else if (temp.peek() == '[' && sb.charAt(i) == ']') {
							temp.pop();
						} else
							possible = false;
					}
				}
			}

			if (possible && temp.isEmpty())
				answer++;
		}
		return answer;
	}
}