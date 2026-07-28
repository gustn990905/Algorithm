import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 매트 크기 정렬
        Arrays.sort(mats);
        
        // 가장 큰 돗자리부터 확인
        for(int i=mats.length-1; i>=0; i--) {
            int size = mats[i];
            
            if(canPlace(size, park)) {
                return size;
            }
        }
        
        // 아무 돗자리도 놓을 수 없는 경우
        return -1;
    }
    
    static boolean canPlace(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        // 공원보다 돗자리가 크면 놓을 수 없음
        if(size > rows || size > cols) return false;
        
        // 돗자리의 왼쪽 위부터 확인
        for(int r=0; r<=rows-size; r++) {
            for(int c=0; c<=cols-size; c++) {
                
                boolean possible = true;
                
                loop:
                for(int dr=0; dr<size; dr++) {
                    for(int dc=0; dc<size; dc++) {
                        if(!park[r+dr][c+dc].equals("-1")) {
                            possible = false;
                            break loop;
                        }
                    }
                }
                
                if(possible) return true;
            }
        }return false;
    }
}