class Solution {
    public String solution(String X, String Y) {
        // X와 Y에서 숫자 0~9등장한 횟수 세기
        int[] cntX = new int[10];
        int[] cntY = new int[10];

        for(int i=0; i<X.length(); i++) {
            cntX[X.charAt(i) - '0']++;
        }
        for(int i=0; i<Y.length(); i++) {
            cntY[Y.charAt(i) - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        // 가장 큰 수를 만들기 위해서 9부터 확인
        for(int n=9; n>=0; n--) {
            // 공통 수
            int commonNum = Math.min(cntX[n], cntY[n]);
            
            for(int c=0; c<commonNum; c++) {
                answer.append(n);
            }
        }
        
        // 공통 숫자가 하나도 없는 경우
        if(answer.length() == 0) {
            return "-1";
        }
        
        // 가장 큰 숫자가 0이면 모든 숫자가 0
        if(answer.charAt(0) == '0') return "0";

        return answer.toString();
    }
}