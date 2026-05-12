import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
	
	static int N; // 섬의 개수
	static int E; // 섬과 섬 사이의 연결 개수
	static int[] parent; // 부모 노드를 저장
	
    public int solution(int n, int[][] costs) {
    	N = n;
    	E = costs.length;
    	
    	parent = new int[N]; // 섬의 번호는 0부터 시작

    	// 시작할 때는 모든 부모 노드가 자기 자신
    	for(int i=0; i<N; i++) {
    		parent[i] = i;
    	}
    	
    	// 비용이 낮은 순서대로 정렬
    	Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
    	
        int answer = kruscal(costs);
        return answer;
    }
    
    static int kruscal(int[][] costs) {
    	int sum = 0;
    	
    	int cnt = 0; // 연결된 간선의 수
    	for(int[] edge : costs) {
    		int v1 = edge[0];
    		int v2 = edge[1];
    		int cost = edge[2];
    		
    		if(union(v1, v2)) {
    			sum += cost;
    			cnt++;
    		}
    		
    		if(cnt >= N-1) break;
    	}
    	
    	return sum;
    }
    
    static boolean union(int v1, int v2) {
    	int v1Root = find(v1);
    	int v2Root = find(v2);
    	
    	// 사이클을 만드는 경우
    	if(v1Root == v2Root) return false;
    	
    	parent[v2Root] = v1Root;
    	return true;
    }
    
    static int find(int v) {
    	if(parent[v] == v) return v;
    	
    	return parent[v] = find(parent[v]);
    }
}