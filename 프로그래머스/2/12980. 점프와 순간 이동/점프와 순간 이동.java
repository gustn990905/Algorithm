class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 홀수가 나오면 +1, 짝수면 나누기 2
        while(n != 0) {
        	if(n % 2 == 0) n /= 2;
        	else {
        		n -= 1;
        		answer++;
        	}
        }
        
        return answer;
    }
}