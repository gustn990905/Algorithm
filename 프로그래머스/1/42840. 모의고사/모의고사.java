import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
    	// 각 사람이 제출한 정답
    	int[] p1 = {1, 2, 3, 4, 5};
    	int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	
    	// 각 사람이 획득한 점수
    	int c1 = 0;
    	int c2 = 0;
    	int c3 = 0;
    	
    	for(int i=0; i<answers.length; i++) {
    		if(answers[i] == p1[i%5]) c1++;
    		if(answers[i] == p2[i%8]) c2++;
    		if(answers[i] == p3[i%10]) c3++;
    	}
    	
    	int max = Math.max(c1, Math.max(c2, c3));
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	if(max == c1) list.add(1);
    	if(max == c2) list.add(2);
    	if(max == c3) list.add(3);
    	
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}