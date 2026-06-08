import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        int price = 0;
        for(int i=0; i<d.length; i++) {
        	int temp = price + d[i];
        	
        	if(temp <= budget) {
        		price += d[i];
        		answer++;
        	} else break;
        }
        
        return answer;
    }
}