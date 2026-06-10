class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
        	// 처음 나온 숫자
        	if(i == 0) {
        		answer[i] = -1;
        		continue;
        	}
        	
        	answer[i] = -1;
        	
        	for(int j=i-1; j>=0; j--) {
        		if(s.charAt(i) == s.charAt(j)) {
        			answer[i] = i - j;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}