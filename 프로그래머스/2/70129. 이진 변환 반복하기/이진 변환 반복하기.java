class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0; // 이진 변환 횟수
        int cntZero = 0; // 삭제된 0의 개수

        int zero = 0; // 현재 0의 개수

        while(!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            // 현재 s에 0이 몇 개인지 확인
            for(int i=0; i<s.length(); i++) {
                // 0이면 제거
                if(s.charAt(i) == '0') zero++;

                else sb.append(s.charAt(i));
            }

            cntZero += zero;

            // 문자열로 전환
            String str = sb.toString();

            int length = str.length();

            s = Integer.toString(length, 2);

            cnt++;

            zero = 0;
        }

        answer[0] = cnt;
        answer[1] = cntZero;

        return answer;
    }
}