// 재귀 백트래킹 방식으로 풀어보기
class Solution {

    public int answer;

    public int solution(int[] number) {
        answer = 0;
        select(number, 0, 0, 0);
        return answer;
    }

    public void select(int[] number, int start, int depth, int sum) {
        // 학생 3명을 모두 선택한 경우
        if(depth == 3) {
            if(sum == 0) {
                answer++;
            }
            return;
        }

        // start부터 학생을 한 명씩 선택
        for(int i=start; i<number.length; i++) {
            select(number, i+1, depth+1, sum+number[i]);
        }
    }
}