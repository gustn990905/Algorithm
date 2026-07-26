class Solution {
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];
        
        int currentR = 0;
        int currentC = 0;
        
        for(int r=0; r<park.length; r++) {
            for(int c=0; c<park[r].length(); c++) {
                map[r][c] = park[r].charAt(c);
                
                if (map[r][c] == 'S') {
                    currentR = r;
                    currentC = c;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] command = routes[i].split(" ");

            char op = command[0].charAt(0);
            int n = Integer.parseInt(command[1]);
            
           int direction = 0;
            
            if (op == 'N') {
                direction = 0;
            } else if (op == 'S') {
                direction = 1;
            } else if (op == 'W') {
                direction = 2;
            } else if (op == 'E') {
                direction = 3;
            }
            
            // 실제 위치를 바로 변경하지 않고 임시 위치로 확인
            int nextR = currentR;
            int nextC = currentC;
            
            boolean possible = true;
            
            // 한 칸씩 이동하면서 범위와 장애물 확인
            for (int j = 0; j < n; j++) {
                nextR += dr[direction];
                nextC += dc[direction];
                
                // 공원을 벗어나는 경우
                if (nextR < 0 || nextR >= map.length
                        || nextC < 0 || nextC >= map[0].length) {
                    possible = false;
                    break;
                }
                
                // 장애물을 만나는 경우
                if (map[nextR][nextC] == 'X') {
                    possible = false;
                    break;
                }
            }
            
            // 끝까지 이동 가능한 경우에만 현재 위치 변경
            if (possible) {
                currentR = nextR;
                currentC = nextC;
            }
        }
        
        return new int[]{currentR, currentC};
    }
}