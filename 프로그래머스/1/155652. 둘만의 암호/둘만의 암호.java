class Solution {
    public String solution(String s, String skip, int index) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        String answer = "";

        for(int i=0; i<s.length(); i++) {
            int cnt = 0; // 실제 이동한 알파벳 개수
            char now = s.charAt(i);

            while(cnt < index) {
                // 알파벳 한 칸 증가
                now++;

                // z를 넘어가면 다시 a로
                if(now > 'z') now = 'a';

                // skip에 없는 문자라면 이동 횟수 증가
                if(skip.indexOf(now) == -1) cnt++;
            }

            // 변환 끝난 문자를 결과 문자열에 추가
            answer += now;
        }
        return answer;
    }
}