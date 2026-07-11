class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        String target = board[h][w];

        int answer = 0;
        int height = board.length;
        int width = board[0].length;

        for(int i=0; i<4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];

            // 범위를 벗어나면 continue
            if(nr<0 || nr>=height || nc<0 || nc>=width) continue;

            // 같은 색이면 answer++
            if(board[nr][nc].equals(target)) answer++;
        }

        return answer;
    }
}