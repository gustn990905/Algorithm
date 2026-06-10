class Solution {
    public int solution(int[][] sizes) {        
        int a = 0;
        int b = 0;
        for(int i=0; i<sizes.length; i++) {
        	int x = sizes[i][0];
        	int y = sizes[i][1];
        	
        	if(x >= y) {
        		a = Math.max(a, x);
        		b = Math.max(b, y);
        	}
        	else {
        		a = Math.max(a, y);
        		b = Math.max(b, x);
        	}
        }
        
        return a*b;
    }
}