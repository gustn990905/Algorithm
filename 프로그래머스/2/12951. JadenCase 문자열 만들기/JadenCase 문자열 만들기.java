class Solution {
    public String solution(String s) {
        String answer = "";

        boolean first = true;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            // 공백이면 그대로 넣고 다음 문자를 첫 글자로 처리
            if(c == ' ') {
                answer += c;
                first = true;
            }

            else {
                if(first) {
                    answer += Character.toUpperCase(c);
                    first = false;
                }
                else {
                    answer += Character.toLowerCase(c);
                }
            }
        }

        return answer;
    }
}