import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
                
        // 모든 사람을 확인
        for(int i=0; i<timelogs.length; i++) {
            int day = startday; // 확인할 날짜
            boolean possible = true; // 상품을 받을 수 있는지
            
            // 출근 희망 시각 +10분을 분 단위로 계산
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100;
            int limit = hour * 60 + min + 10;
            
            // 각 사람의 모든 출근 시간 확인
            loop:
            for(int j=0; j<timelogs[0].length; j++) {
                // day가 7일 일요일을 넘어가면 월요일로 돌아오기
                if(day > 7) day = 1;
                
                // 확인하는 날짜가 토요일이거나 일요일이면 넘어가기
                if(day == 6 || day == 7) {
                    day++;
                    continue;
                }
                
                // 평일이면서 출근 희망 시각 범위 안에 출근을 했는지 확인
                else {
                    // 실제 출근 시각을 분 단위로 변환
                    int arrHour = timelogs[i][j] / 100;
                    int arrMin = timelogs[i][j] % 100;
                    int arrival = arrHour * 60 + arrMin;
                    
                    // 범위를 벗어나게 출근하면 possible = false 후 break
                    if(arrival > limit) {
                        possible = false;
                        break loop;
                    }
                }
                                
                // 확인 날짜 다음 넘어가기
                day++;
            }
            // 모든 평일에 출근 희망 시각 범위 안에 출근을 했으면 answer++
            if(possible) answer++;
        }
        
        return answer;
    }
}