import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int item : ingredient) {
            // 재료를 순서대로 쌓기
            stack.push(item);

            // 재료가 최소 4개 이상 있어야 햄버거 확인 가능
            if(stack.size() >= 4) {
                int size = stack.size();

                // 스택의 마지막 4개가 빵, 야채, 고기, 빵인지 확인
                if(stack.get(size-4) == 1
                && stack.get(size-3) == 2
                && stack.get(size-2) == 3
                && stack.get(size-1) == 1) {
                    // 햄버거 재료 4개 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    answer++;
                }
            }
        }
        return answer;
    }
}