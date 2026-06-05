class Solution {
    public long solution(int price, int money, int count) {
        long finalPrice = 0; // 필요한 금액
    	for(int c=1; c<=count; c++) {
    		finalPrice += price*c;
    	}
    	
    	long answer = money - finalPrice;
    	
    	if(answer >= 0) answer = 0;
    	else answer = Math.abs(answer);

        return answer;
    }
}