class Solution {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0); // 현재 구간의 첫 번째 문자
        int same = 0; // x와 같은 문자의 개수
        int diff = 0; // x와 다른 문자의 개수

        for(int i=0; i<s.length(); i++) {
            // 현재 문자가 x와 같은지 확인
            if(s.charAt(i) == x) same++;
            else diff++;
            
            // same과 diff가 같아지면 문자열 분리
            if(same == diff) {
                answer++;
                
                // 다음 구간이 존재하면 새로운 x 찾기
                if(i+1 < s.length()) {
                    x = s.charAt(i+1);
                }
                
                // 다음 구간을 세기 위해 초기화
                same = 0;
                diff = 0;
            }
        }
        
        // 모든 문자를 확인했지만 아직 분리되지 않은 문자가 남은 경우
        if(same != 0 || diff != 0) answer++;

        return answer;
    }
}