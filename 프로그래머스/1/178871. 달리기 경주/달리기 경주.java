import java.util.HashMap;

class Solution {

    public String[] solution(String[] players, String[] callings) {

        // 선수 이름 -> 현재 등수
        HashMap<String, Integer> rank = new HashMap<>();

        // 초기 등수 저장
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        // 호출 처리
        for (String call : callings) {

            // 현재 호출된 선수의 위치
            int currentIdx = rank.get(call);

            // 바로 앞 선수
            String frontPlayer = players[currentIdx - 1];

            // 자리 교환
            players[currentIdx - 1] = call;
            players[currentIdx] = frontPlayer;

            // 등수 갱신
            rank.put(call, currentIdx - 1);
            rank.put(frontPlayer, currentIdx);
        }

        return players;
    }
}