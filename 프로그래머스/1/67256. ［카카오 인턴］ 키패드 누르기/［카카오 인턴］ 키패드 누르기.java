class Solution {
    public String solution(int[] numbers, String hand) {
    	char[][] phone = {{'1','2','3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};
    	
        StringBuilder answer = new StringBuilder();
        
        // 처음 손의 위치
        int leftRow = 3;
        int leftCol = 0;
        
        int rightRow = 3;
        int rightCol = 2;
        
        for(int i=0; i<numbers.length; i++) {
        	int push = numbers[i];
        	
        	// 현재 눌러야 할 숫자의 좌표
        	int pushRow = 0;
        	int pushCol = 0;
        	
        	// phone 배열에서 숫자의 위치 찾기
        	loop:
        	for(int row = 0; row < phone.length; row++) {
        		for(int col = 0; col<phone[row].length; col++) {
        			if(phone[row][col] - '0' == push) {
        				pushRow = row;
        				pushCol = col;
        				break loop;
        			}
        		}
        	}
        	
        	// 1, 4, 7은 왼손
        	if(push == 1 || push == 4 || push == 7) {
        		answer.append("L");
        		
        		leftRow = pushRow;
        		leftCol = pushCol;
        	}
        	
        	// 3, 6, 9는 오른손
        	else if(push == 3 || push == 6 || push == 9) {
        		answer.append("R");
        		
        		rightRow = pushRow;
        		rightCol = pushCol;
        	}
        	
        	// 2, 5, 8, 0은 거리 비교
        	else {
        		int leftDistance = Math.abs(leftRow - pushRow) + Math.abs(leftCol - pushCol);        		
        		int rightDistance = Math.abs(rightRow - pushRow) + Math.abs(rightCol - pushCol);
        		
        		if(leftDistance < rightDistance) {
        			answer.append("L");
        			
        			leftRow = pushRow;
        			leftCol = pushCol;
        		}
        		else if(leftDistance > rightDistance) {
        			answer.append("R");
        			
        			rightRow = pushRow;
        			rightCol = pushCol;
        		}
        		else {
        			// 거리가 같다면 주로 사용하는 손
        			if(hand.equals("left")) {
        				answer.append("L");
        				
        				leftRow = pushRow;
            			leftCol = pushCol;
        			} else {
        				answer.append("R");
            			
            			rightRow = pushRow;
            			rightCol = pushCol;
        			}
        		}
        	}
        }
        
        return answer.toString();
    }
}