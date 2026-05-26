class Solution {
    public boolean solution(int x) {
    	String num = String.valueOf(x);
    	
    	int h = 0;
    	
    	for(int i=0; i<num.length(); i++) {
    		h += num.charAt(i) - '0';
    	}
    	
        boolean answer = true;
        
        if(x % h == 0) answer=true;
        else answer = false;
        
        return answer;
    }
}