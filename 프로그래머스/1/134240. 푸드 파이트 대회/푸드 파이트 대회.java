class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++) {
        	int prepare = food[i]/2;
        	for(int j=0; j<prepare; j++) {
        		answer += i;
        	}
        }
        
        // 물 세팅
        answer += 0;
        
        String finalAnswer ="";
        finalAnswer += answer;
        int size = answer.length()-2;
        for(int i=size; i>=0; i--) {
        	finalAnswer += answer.charAt(i); 
        }
        
        return finalAnswer;
    }
}