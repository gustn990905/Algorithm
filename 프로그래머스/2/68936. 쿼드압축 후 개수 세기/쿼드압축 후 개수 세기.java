class Solution {
	
	int zero = 0;
	int one = 0;
	int[][] arr1;
	
    public int[] solution(int[][] arr) {
    	arr1 = arr;
    	
        divide(0, 0, arr.length);
    	
        return new int[] {zero, one};
    }
    
    void divide(int x, int y, int size) {
    	int target = arr1[x][y];
    	
    	boolean same = true;
    	
    	for(int i=x; i<x+size; i++) {
    		for(int j=y; j<y+size; j++) {
    			
    			if(arr1[i][j] != target) {
    				same = false;
    				break;
    			}
    		}
    		
    		if(!same) break;
    	}
    	
    	if(same) {
    		if(target == 0) zero++;
    		else one++;
    		
    		return; // 만약 확인하는 영역의 숫자가 모두 같으면 더 이상 쪼개지 않아도 됨
    	}
    	
    	int half = size / 2;
    	
    	divide(x, y, half);
    	divide(x, y+half, half);
    	divide(x+half, y, half);
    	divide(x+half, y+half, half);
    }
}