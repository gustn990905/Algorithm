class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
        	// 공백이 나오면 공백으로 채우기
        	if(s.charAt(i) == ' ') answer += ' ';
        	
        	// 대문자가 입력된 경우
        	else if(Character.isUpperCase(s.charAt(i))) {
        		answer += (char)('A' + (s.charAt(i) - 'A' + n) % 26);
        	}
        	
        	// 소문자가 입력된 경우
        	else {
        		answer += (char)('a' + (s.charAt(i) -'a' + n) % 26);
        	}
        }
        return answer;
    }
}