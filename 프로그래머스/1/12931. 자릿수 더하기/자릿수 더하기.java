import java.util.*;

public class Solution {
    public int solution(int n) {
    	String num = String.valueOf(n);
    	
    	int answer = 0;
    	for(int i=0; i<num.length(); i++) {
    		int number = num.charAt(i) - '0';
    		answer += number;
    	}
        
        System.out.println(answer);

        return answer;
    }
}