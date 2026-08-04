import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {

        // 각 문자가 스포인지 표시
        boolean[] isSpoiler = new boolean[message.length()];

        // 스포 구간에 포함된 문자를 true로 변경
        for (int[] range : spoiler_ranges) {
            int start = range[0];
            int end = range[1];

            for (int i = start; i <= end; i++) {
                isSpoiler[i] = true;
            }
        }

        // 일반 단어 저장
        Set<String> normalWords = new HashSet<>();

        // 스포 단어 저장
        Set<String> spoilerWords = new HashSet<>();

        String[] words = message.split(" ");

        // 현재 단어가 시작하는 문자 위치
        int wordStart = 0;

        for (String word : words) {

            boolean spoilerWord = false;

            // 단어의 문자 중 하나라도 스포인지 확인
            for (int i = 0; i < word.length(); i++) {
                if (isSpoiler[wordStart + i]) {
                    spoilerWord = true;
                    break;
                }
            }

            if (spoilerWord) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }

            // 다음 단어 시작 위치로 이동
            wordStart += word.length() + 1;
        }

        // 일반 영역에도 나온 단어 제거
        spoilerWords.removeAll(normalWords);

        // 남은 스포 단어의 개수
        return spoilerWords.size();
    }
}