import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	int answer = 0;

    	Stack<Integer> basket = new Stack<>(); // 바구니
    	
    	// 전체 moves 다 확인
    	for(int i=0; i<moves.length; i++) {
    		int move = moves[i] - 1; // 지금 인형을 집을 위치
    		
    		int doll = 0; // 집은 인형
    		for(int j=0; j<board[0].length; j++) {
    			// 인형이 있는 경우
    			if(board[j][move] != 0) {
    				doll = board[j][move];
    				
    				// 바구니의 인형과 같으면 터짐
    				if(!basket.isEmpty() && basket.peek() == doll) {
    					basket.pop();
    					answer += 2;
    				}
    				
    				// 아니면 바구니에 담기 
    				else {
    					basket.add(doll);
    				}
    				
    				// 뽑은 인형 제거
    				board[j][move] = 0;
    				break;
    			}
    		}
    	}
        return answer;
    }
}