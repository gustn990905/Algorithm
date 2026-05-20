import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
    	String num = String.valueOf(n);
    	
    	int[] arr = new int[num.length()];
    	
    	for(int i=0; i<num.length(); i++) {
    		arr[i] = num.charAt(i) - '0';
    	}
    	
    	Arrays.sort(arr);
    	
        StringBuilder sb = new StringBuilder();
        
        for(int i=arr.length-1; i>=0; i--) {
        	sb.append(arr[i]);
        }
        
        long answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}