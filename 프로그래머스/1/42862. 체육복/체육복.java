import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 각 학생이 가진 체육복 수
        int[] clothes = new int[n+1];

        // 모든 학생은 기본적으로 체육복 1벌 보유
        Arrays.fill(clothes, 1);

        // 도난 당한 학생
        for(int student : lost) {
            clothes[student]--;
        }

        // 여벌이 있는 학생
        for(int student : reserve) {
            clothes[student]++;
        }

        // 번호가 작은 학생부터 체육복을 빌림
        for(int student = 1; student<=n; student++) {
            // 체육복이 없는 학생만 확인
            if(clothes[student] == 0) {
                // 앞 번호 학생에게 여벌이 있으면 먼저 빌리기
                if(student > 1 && clothes[student-1] >= 2) {
                    clothes[student-1]--;
                    clothes[student]++;
                }

                // 앞 번호에게 빌리지 못하면 뒷 번호 확인
                else if(student < n && clothes[student+1] == 2) {
                    clothes[student+1]--;
                    clothes[student]++;
                }
            }
        }
        int answer = 0;

        // 체육복이 한 벌 이상 있는 학생 수 계산
        for(int i=1; i<=n; i++) {
            if(clothes[i] >= 1) answer++;
        }

        return answer;
    }
}