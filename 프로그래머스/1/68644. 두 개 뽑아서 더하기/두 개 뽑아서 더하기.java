import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i=0; i<numbers.length; i++) {
    		for(int j=0; j<numbers.length; j++) {
    			if(i == j) continue;
    			
    			set.add(numbers[i] + numbers[j]);
    		}
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>(set);
    	
    	Collections.sort(list);
    	
    	int[] answer = new int[list.size()];
    	for(int i=0; i<list.size(); i++) {
    		answer[i] = list.get(i);
    	}
        return answer;
    }
}