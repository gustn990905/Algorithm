import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
    	
    	Arrays.sort(strings, (a, b) -> {
    		// n번째 문자가 같은 경우
    		if(a.charAt(n) == b.charAt(n)) {
    			return a.compareTo(b);
    		}
    		return Character.compare(a.charAt(n), b.charAt(n));
    	});
 
        return strings;
    }
}