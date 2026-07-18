import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userCount = id_list.length;

        // 각 사용자가 받은 결과 메일 수
        int[] answer = new int[userCount];

        // 각 사용자가 신고당한 횟수
        int[] reportedCount = new int[userCount];

        // 사용자 이름을 숫자로 변환
        Map<String, Integer> userIdx = new HashMap<>();
        
        // 사용자 이름과 배열 인덱스를 map에 저장
        for(int i=0; i<userCount; i++) {
            userIdx.put(id_list[i], i);
        }

        // 중복 신고를 제거하기 위해 hashmap 사용
        Set<Integer>[] graph = new HashSet[userCount];

        for(int i=0; i<userCount; i++) {
            graph[i] = new HashSet<>();
        }

        // 신고 관계 저장
        for(String reportInfo : report) {
            String[] parts = reportInfo.split(" ");

            String reporterName = parts[0];
            String reportedName = parts[1];

            int reporter = userIdx.get(reporterName);
            int reported = userIdx.get(reportedName);

            // 새로운 신고인 경우 true 반환
            // 중복 신고라면 false 반환
            if(graph[reporter].add(reported)) {
                reportedCount[reported]++;
            }
        }

        // 각 사용자가 신고한 사람 중 정지된 사람이 몇 명인지 확인
        for(int r=0; r<userCount; r++) {
            for(int reported : graph[r]) {
                // k 번 이상 신고당했다면 정지 대상
                if(reportedCount[reported] >= k) {
                    answer[r]++;
                }
            }
        }

        return answer;
    }
}