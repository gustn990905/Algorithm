class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초딩 회복량
        int y = bandage[2]; // 추가 회복량
        int attackTime = attacks[attacks.length-1][0]; // 공격 시간
        int nowHealth = health; // 현재 체력
        int cnt = 0; // 연속 성공
        int attackCnt = 0; // 어디까지 공격했는지 저장

        // 공격 시간만큼 공격
        for(int time=1; time<=attackTime; time++) {
            // 공격이 있는지 아닌지 확인
            int attack = attacks[attackCnt][0];

            // 공격이 있는 경우
            if(attack == time) {
                // 연속 공격 초기화
                cnt = 0;
                // 공격 적용
                nowHealth -= attacks[attackCnt][1];
                // 공격 저장 +1
                attackCnt++;

                // 공격받고 체력이 0 이하라면 즉시 사망
                if (nowHealth <= 0) {
                    return -1;
                }
            }

            // 공격이 없는 경우
            else {
                // 체력 회복
                nowHealth += x;
                // 연속 성공 적용
                cnt++;
                // 연속 성공 규칙 만족시 추가 체력 획득
                if(cnt >= t) {
                    nowHealth += y;
                    cnt = 0;
                }
                // 최대 체력을 넘을 수 없음
                if(nowHealth > health) {
                    nowHealth = health;
                }
            }
        }

        return nowHealth;
    }
}