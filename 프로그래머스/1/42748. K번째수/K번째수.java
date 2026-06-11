import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	for(int i=0; i<commands.length; i++) {
    		ArrayList<Integer> list = new ArrayList<>();
    		for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
    			list.add(array[j]);
    		}
    		
    		Collections.sort(list);
    		result.add(list.get(commands[i][2]-1));
    	}
    	
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
}