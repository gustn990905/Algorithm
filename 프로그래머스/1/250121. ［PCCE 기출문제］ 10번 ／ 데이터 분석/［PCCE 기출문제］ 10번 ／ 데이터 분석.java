import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int idx = 0; // 몇 번째 데이터인지
    	if(ext.equals("code")) idx = 0;
    	else if(ext.equals("date")) idx = 1;
    	else if(ext.equals("maximum")) idx = 2;
    	else idx = 3;
    	
    	int cnt = 0; // val_ext 보다 작은 값이 몇 개인지
    	for(int i=0; i<data.length; i++) {
    		if(data[i][idx] < val_ext) cnt++;
    	}
    	
    	int[][] answer = new int[cnt][4];
    	int idxx = 0;
    	for(int i=0; i<data.length; i++) {
    		if(data[i][idx] < val_ext) {
    			for(int j=0; j<4; j++) {
    				answer[idxx][j] = data[i][j]; 
    			}
    			idxx++;
    		}
    	}
    	
    	if(sort_by.equals("code")) Arrays.sort(answer, (a, b) -> Integer.compare(a[0], b[0]));
    	else if(sort_by.equals("date")) Arrays.sort(answer, (a, b) -> Integer.compare(a[1], b[1]));
    	else if(sort_by.equals("maximum")) Arrays.sort(answer, (a, b) -> Integer.compare(a[2], b[2]));
    	else Arrays.sort(answer, (a, b) -> Integer.compare(a[3], b[3]));
    		
        return answer;
    }
}