import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; // 블록의 개수
	static int result;
	static List<Integer> block;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // testcase 수
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			block = new ArrayList<>(); // 블록을 자주 넣었다가 빼서 list 크기가 계속 달라짐
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N; n++) {
				block.add(Integer.parseInt(st.nextToken()));
			}
			
			result = 0;
			findMaxScore(block, 0);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void findMaxScore(List<Integer> block, int sum) {
		// 블록이 없으면 max값 찾기
		if(block.size() == 0) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<block.size(); i++) {
			
			int score = 0; 
			
			if(block.size() == 1) score = block.get(i);
			else if(i==0) score = block.get(1);
			else if(i==block.size()-1) score = block.get(block.size()-2);
			else score = block.get(i-1) * block.get(i+1);
			
			int remove = block.remove(i);
			findMaxScore(block, sum + score);
			block.add(i, remove);
		}
	}
}