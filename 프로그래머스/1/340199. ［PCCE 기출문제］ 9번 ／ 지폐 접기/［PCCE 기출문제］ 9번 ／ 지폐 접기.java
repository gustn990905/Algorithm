class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {
        	// 지갑에 넣을 수 있으면 멈추기
        	if((bill[0] <= wallet[0] && bill[1] <= wallet[1]) || bill[0] <= wallet[1] && bill[1] <= wallet[0]) {
        		break;
        	}
        	
        	// bill[0] >= bill[1]인 경우
        	if(bill[0] >= bill[1]) {
        		bill[0] /= 2;
        		answer++;
        	} 
        	
        	else {
        		bill[1] /= 2;
        		answer++;
        	}
        }
        
        return answer;
    }
}