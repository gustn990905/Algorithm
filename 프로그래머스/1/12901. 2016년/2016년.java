class Solution {
    public String solution(int a, int b) {
    	String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    	int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
    	int cnt = b - 1;
    	// 직전 달까지 몇 일이 있는지 계산
    	for(int i=0; i<a-1; i++) {
    		cnt += month[i];
    	}
    	
    	int idx = 5; // 1월 1일은 금요일
    	
    	idx = (5 + (cnt % 7)) % 7;
    	
        String answer = "";
        answer += day[idx];
        return answer;
    }
}