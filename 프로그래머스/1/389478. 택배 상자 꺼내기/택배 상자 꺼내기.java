class Solution {
    public int solution(int n, int w, int num) {
        int h = n / w;
        if(n % w != 0) h++;

        // 상자를 실제로 저장
        int[][] map = new int[h][w];

        // 꺼내려는 상자의 위치
        int targetRow = 0;
        int targetCol = 0;

        // 현재 배치할 상자 번호
        int box = 1;

        // 아래층부터 한 층씩 상자 배치
        for(int r=0; r<h; r++) {
            // 짝수 층이면 왼 -> 오
            if(r % 2 == 0) {
                for(int c=0; c<w; c++) {
                    // n번 상자까지 모두 넣었으면 종료
                    if (box > n) {
                        break;
                    }

                    map[r][c] = box;
                    
                    if(box == num) {
                        targetRow = r;
                        targetCol = c;
                    }
                    box++;
                }
            }

            // 홀수 층이면 오 -> 왼
            else {
                for(int c=w-1; c>=0; c--) {
                    // n번 상자까지 모두 넣었으면 종료
                    if (box > n) {
                        break;
                    }

                    map[r][c] = box;
                    
                    if(box == num) {
                        targetRow = r;
                        targetCol = c;
                    }
                    box++;
                }
            }
        }

        int answer = 0;

        // 꺼내려는 상자가 있는 층부터 위층까지 확인
        for(int r=targetRow; r<h; r++) {
            // 같은 세로줄에 상자가 있으면 꺼내야 함
            if(map[r][targetCol] != 0) {
                answer++;
            }
        }

        return answer;
    }
}