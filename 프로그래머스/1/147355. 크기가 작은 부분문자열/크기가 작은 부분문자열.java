class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pNum = Long.parseLong(p);
        
        int pLength = p.length();
        for(int i=0; i<=t.length()-pLength; i++) {
        	String num = t.substring(i, i+pLength);
        	
        	long a = Long.parseLong(num);
        	
        	if(a <= pNum) answer++;
        }
        
        return answer;
    }
}