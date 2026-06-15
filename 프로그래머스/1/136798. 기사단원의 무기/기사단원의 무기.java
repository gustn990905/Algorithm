class Solution {
    public int solution(int number, int limit, int power) {

        int[] cnt = new int[number];
        
        for(int i=1; i<=number; i++) {
        	int count = 0;
        	for(int j=1; j<=i; j++) {
        		if(i % j == 0) count++;
        	}
        	cnt[i-1] = count;
        }
        
        int answer = 0;
        for(int i=0; i<number; i++) {
        	if(cnt[i] > limit) answer += power;
        	else answer += cnt[i];
        }
        
        return answer;
    }
}