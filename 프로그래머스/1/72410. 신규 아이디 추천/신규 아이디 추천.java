class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자 치완
        String answer1 = new_id.toLowerCase();

        // 2단계
        StringBuilder answer2 = new StringBuilder();
        for(int i=0; i<answer1.length(); i++) {
            char c = answer1.charAt(i);

            if((c>='a' && c<='z') || (c >= '0' && c <= '9') || c=='-' || c == '_' || c == '.') {
                answer2.append(c);
            }
        }

        // 3단계
        StringBuilder answer3 = new StringBuilder();
        for(int i=0; i<answer2.length(); i++) {
            char c = answer2.charAt(i);

            // 현재 문자가 마침표이고, 바로 앞 저장 문자도 마침표면 건너뜀
            if(c == '.' && answer3.length() > 0 && answer3.charAt(answer3.length()-1) == '.') {
                continue;
            }

            answer3.append(c);
        }

        // 4단계
        if (answer3.length() > 0 && answer3.charAt(0) == '.') {
            answer3.deleteCharAt(0);
        }
        if (answer3.length() > 0
                && answer3.charAt(answer3.length() - 1) == '.') {
            answer3.deleteCharAt(answer3.length() - 1);
        }

        // 5단계
        if(answer3.length() == 0) answer3.append('a');

        // 6단계
        if(answer3.length() >= 16) {
            answer3.delete(15, answer3.length());
        }
        if(answer3.charAt(answer3.length()-1) == '.') {
            answer3.deleteCharAt(answer3.length()-1);
        }
        
        // 7단계
        while(answer3.length() < 3) {
            char last = answer3.charAt(answer3.length()-1);
            answer3.append(last);
        }

        return answer3.toString();
    }
}