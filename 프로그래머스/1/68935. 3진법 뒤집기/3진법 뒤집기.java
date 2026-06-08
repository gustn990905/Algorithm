class Solution {
    public int solution(int n) {
    	String num3 = Integer.toString(n, 3);
    	
    	String numReverse = "";
    	
    	for(int i=num3.length()-1; i>=0; i--) {
    		numReverse += num3.charAt(i);
    	}
    	
        int answer = Integer.parseInt(numReverse, 3);
        return answer;
    }
}