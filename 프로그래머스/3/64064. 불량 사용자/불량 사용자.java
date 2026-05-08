import java.util.HashSet;
import java.util.Set;

class Solution {
	
	// 최종 경우의 수 저장 
	// Set을 사용해 중복 제거
	Set<Set<String>> result = new HashSet<>();
	
	// user 사용 여부 체크
	boolean[] visited;
	
    public int solution(String[] user_id, String[] banned_id) {
    	visited = new boolean[user_id.length];
    	
    	// DFS 
    	DFS(0, user_id, banned_id, new HashSet<>());
    	
        int answer = result.size();
        return answer;
    }
    
    // depth: 현재 banned_id의 idx, set: 현재까지 선택된 user_id
    void DFS(int depth, String[] user_id, String[] banned_id, Set<String> set) {
    	// banned_id를 모두 처리한 경우
    	if(depth == banned_id.length) {
    		result.add(new HashSet<>(set));
    		return;
    	}
    	
    	String banned = banned_id[depth];
    	
    	for(int i=0; i<user_id.length; i++) {
    		if(visited[i]) continue;
    		
    		// banned과 user_id[i]가 일치하지 않으면 continue
    		if(!match(user_id[i], banned)) continue;
    		
    		visited[i] = true;
    		
    		set.add(user_id[i]);
    		
    		DFS(depth+1, user_id, banned_id, set);
    		
    		// 백트래킹
    		visited[i] = false;
    		set.remove(user_id[i]);
    	}
    }
    
    boolean match(String user, String banned) {
    	// 길이 다르면 false
    	if(user.length() != banned.length()) return false;
    	
    	for(int i=0; i<user.length(); i++) {
    		char b = banned.charAt(i);
    		
    		if(b == '*') continue;
    		
    		if(user.charAt(i) != b) return false;
    	}
    	return true;
    }
}