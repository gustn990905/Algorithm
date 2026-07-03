class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 숫자 3개 선택하기
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			int num = nums[i] + nums[j] + nums[k];
        			
        			boolean prime = true;
        			for(int l=2; l*l<=num; l++) {
        				if(num % l == 0) {
        					prime = false;
        					break;
        				}
        			}
        			
        			if(prime) answer++;
        		}
        	}
        }

        return answer;
    }
}