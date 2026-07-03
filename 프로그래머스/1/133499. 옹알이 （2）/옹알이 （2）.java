class Solution {
    public int solution(String[] babbling) {

        // 사용할 수 있는 발음
        String[] words = {"aya", "ye", "woo", "ma"};

        int answer = 0;

        // 모든 단어 검사
        for (String s : babbling) {

            int idx = 0;          // 현재 검사할 위치
            String prev = "";     // 직전에 사용한 발음
            boolean possible = true;

            // 문자열을 끝까지 검사
            while (idx < s.length()) {

                boolean found = false; // 현재 위치에서 발음을 찾았는지 여부

                // 4개의 발음을 하나씩 확인
                for (String word : words) {

                    // idx 위치부터 word로 시작하는지 확인
                    if (s.startsWith(word, idx)) {

                        // 같은 발음을 연속해서 사용하면 실패
                        if (prev.equals(word)) {
                            possible = false;
                            break;
                        }

                        // 현재 발음을 사용했으므로
                        // idx를 발음 길이만큼 이동
                        idx += word.length();

                        // 직전에 사용한 발음 갱신
                        prev = word;

                        // 발음을 찾았음을 표시
                        found = true;

                        // 다음 위치 검사
                        break;
                    }
                }

                // 같은 발음을 연속 사용한 경우
                if (!possible) {
                    break;
                }

                // 어떤 발음으로도 시작하지 않으면 실패
                if (!found) {
                    possible = false;
                    break;
                }
            }

            // 문자열 전체를 올바르게 발음할 수 있으면 개수 증가
            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}