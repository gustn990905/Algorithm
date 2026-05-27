class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String ss = s.toLowerCase();
        
        int cntP = 0;
        int cntY = 0;
        
        for(int i=0; i<ss.length(); i++) {
        	if(ss.charAt(i) == 'p') cntP++;
        	else if(ss.charAt(i) == 'y') cntY++;
        }
        
        if(cntP == cntY) answer = true;
        else answer = false;
        
        return answer;
    }
}