import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 단 한 명만 완주를 하지 못했다고 함
        // 졍렬된 participant 배열과 completion의 다른 부분이 나오면 그 사람이 미완주자

        for(int i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) return participant[i];
        }

        // 완주 목록의 끝까지 같다면 마지막에 남은 사람이 미완주자
        return participant[participant.length - 1];
    }
}