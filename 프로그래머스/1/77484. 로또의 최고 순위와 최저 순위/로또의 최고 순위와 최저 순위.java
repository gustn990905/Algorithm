import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int miss = 0; // 지워진 숫자
        int same = 0; // 맞춘 숫자
        
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) miss++;
        	else {
        		for(int j=0; j<win_nums.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				same++;
        				break;
        			}
        		}
        	}
        }
        
        answer[0] = Math.min(6, 7-(same+miss));
        answer[1] = Math.min(6, 7-(same));
        
        return answer;
    }
}