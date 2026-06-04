class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=0; i<n; i++) {
        	if(i == 0) answer += "수";
        	else if(answer.charAt(i-1) == '수') answer += "박";
        	else if(answer.charAt(i-1) == '박') answer += "수";
        }
        return answer;
    }
}