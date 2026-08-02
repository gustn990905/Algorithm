import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 전체 친구 수
        int n = friends.length;

        // 친구 이름을 배열의 인덱스로 바꾸기 위한 Map
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            indexMap.put(friends[i], i);
        }

        // 주고 받은 선물 개수를 저장하는 2차원 배열
        int[][] giftCnt = new int[n][n];

        // 선물 지수를 저장
        int[] giftScore = new int[n];

        // 주고 받은 선물 기록 확인
        for(String gift : gifts) {
            String[] names = gift.split(" ");

            int giver = indexMap.get(names[0]);
            int receiver = indexMap.get(names[1]);

            giftCnt[giver][receiver]++;

            // 선물을 준 사람은 선물 지수 1 증가
            giftScore[giver]++;

            // 선물을 받은 사람은 선물 지수 1 감소
            giftScore[receiver]--;
        }

        // 다음 달에 각 친구가 받을 선물의 개수 저장
        int[] nextGift = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                // i번 친구가 j에게 더 많은 선물을 준 경우
                if(giftCnt[i][j] > giftCnt[j][i]) nextGift[i]++;

                // j가 i에게 더 많은 선물을 준 경우
                else if(giftCnt[i][j] < giftCnt[j][i]) nextGift[j]++;

                // 두 사람이 주고 받은 선물 수가 같다면
                else {
                    // i의 선물 지수가 더 큰 경우
                    if(giftScore[i] > giftScore[j]) nextGift[i]++;

                    // j의 선물 지수가 더 큰 경우
                    else if(giftScore[j] > giftScore[i]) nextGift[j]++;
                }
            }
        }

        // 다음 달에 가장 많은 선물을 받는 친구의 선물 개수
        int answer = 0;

        // 각 친구가 받을 선물 개수 확인
        for(int count : nextGift) {
            answer = Math.max(answer, count);
        }

        return answer;
    }
}