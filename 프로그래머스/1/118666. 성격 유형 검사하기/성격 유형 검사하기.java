class Solution {
    public String solution(String[] survey, int[] choices) {
    	// A~Z 점수를 저장
    	int[] score = new int[26];
    	
    	for(int i=0; i<survey.length; i++) {
    		char disagreeType = survey[i].charAt(0);
    		char agreeType = survey[i].charAt(1);
    		
    		// 비동의인 경우 첫 번째 성격 유형에 점수
    		if(choices[i] < 4) {
    			score[disagreeType - 'A'] += 4 - choices[i];
    		}
    		
    		// 동의인 경우 두 번째 성격 유형에 점수
    		else if(choices[i] > 4) {
    			score[agreeType - 'A'] += choices[i] - 4;
    		}
    	}
    	
    	StringBuilder answer = new StringBuilder();
    	
    	// 각 지표의 두 유형
    	String[] indicators = {"RT", "CF", "JM", "AN"};
    	
    	for(String indicator : indicators) {
    		char first = indicator.charAt(0);
    		char second = indicator.charAt(1);
    		
    		// 점수가 같으면 사전순으로 빠른 유형 선택
    		if(score[first-'A'] >= score[second-'A']) {
    			answer.append(first);
    		}
    		
    		else {
    			answer.append(second);
    		}
    	}
    	
    	return answer.toString();
    }
}