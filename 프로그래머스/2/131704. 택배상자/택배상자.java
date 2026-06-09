import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int boxes = order.length; // 택배상자의 개수
        Stack<Integer> temp = new Stack<>();
        
        int idx = 0;
        for(int b=1; b<=boxes; b++) {
        	temp.add(b); // 일단 넣기
        	
        	// 조건에 맞으면 빼기
        	while(!temp.isEmpty() && temp.peek()==order[idx]) {
        		temp.pop();
        		answer++;
        		idx++;
        		
        		if(idx == boxes) break;
        	}
        }
        
        return answer;
    }
}