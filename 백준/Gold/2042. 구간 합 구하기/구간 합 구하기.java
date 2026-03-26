import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] nums; // 원본 숫자 배열
	static long[] tree; // 세그먼트 트리 배열 (구간 합 저장)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. 원본 숫자 입력 (계산 편의를 위해 1번 인덱스부터 사용)
		nums = new long[N+1];
		for(int n=1; n<=N; n++) {
			nums[n] = Long.parseLong(br.readLine());
		}
		
		// 2. 트리 배열 초기화 (보통 N * 4 크기로 설정)
		tree = new long[N*4];
		
		// 3. 트리 생성 (전체 구간 1 ~ N에 대해 합 계산)
		init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		
		// 4. M + K번의 쿼리 처리
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) update(1, 1, N, b, c);
			else sb.append(sum(1, 1, N, b, (int)c)).append("\n");
		}
		System.out.print(sb);
		
	}
	
	// 세그먼트 트리 초기화
	// 구간을 반으로 나누며 내려가서 리프 노드에 값을 채우고, 올라오면서 부모 노드에 합을 저장함
	static long init(int node, int start, int end) {
		if(start==end) return tree[node] = nums[start];
		
		int mid = (start+end)/2;
		
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	// 특정 인덱스의 값 변경
	// 변경된 리프 노드부터 루트까지 올라오며 연관된 부모 노드들의 합을 모두 갱신
	static long update(int node, int start, int end, int idx, long val) {
		if(idx<start || idx>end) return tree[node];
		
		if(start==end) return tree[node] = val;
		
		int mid = (start+end) / 2;
		
		return tree[node] = update(node*2, start, mid, idx, val) + update(node*2+1, mid+1, end, idx, val);
	}
	
	// 구간 합 구하기
	// 원하는 범위(left~right)에 포함되는 노드들의 합만 골라서 반환
	static long sum(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return 0;
		
		if(left<=start && end <=right) return tree[node];
		
		int mid = (start+end) /2;
		
		return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
 	}
}
