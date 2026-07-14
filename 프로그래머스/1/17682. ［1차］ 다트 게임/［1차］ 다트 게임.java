class Solution {
    public int solution(String dartResult) {
        // 다트를 3번 던짐
        int[] scores = new int[3];
        int round = -1; // 숫자가 나오면 증가

        for(int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            // 숫자인 경우
            if(Character.isDigit(ch)) {
                round++;

                // 점수가 10점인지 확인
                if(ch == '1' && i+1 <dartResult.length() && dartResult.charAt(i+1) == '0') {
                    scores[round] = 10;
                    i++; // 0까지 처리하면 한 칸 건너뜀
                }
                else {
                    scores[round] = ch - '0';
                }
            }

            // 보너스 영역
            else if(ch == 'S') scores[round] = (int)Math.pow(scores[round], 1);
            else if(ch == 'D') scores[round] = (int)Math.pow(scores[round], 2);
            else if(ch == 'T') scores[round] = (int)Math.pow(scores[round], 3);

            // 스타상
            else if(ch == '*') {
                scores[round] *= 2;

                // 이전 점수가 있다면 이전 점수도 2배
                if(round > 0) {
                    scores[round-1] *= 2;
                }
            }

            // 아차상
            else if(ch == '#') {
                scores[round] *= -1;
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}