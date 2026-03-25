import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int[] dh = {-1, 1, 0, 0, 0, 0};
		int[] dn = {0, 0, -1, 1, 0, 0};
		int[] dm = {0, 0, 0, 0, -1, 1};
		
		int[][][] storage = new int[H][M][N];
		Queue<int[]> ripeTomato = new LinkedList<>();
		
		int day = 0;
		
		int raw = 0;
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					int tomato = sc.nextInt();
					storage[h][m][n] = tomato;
					if(tomato == 0) raw++;
					if(tomato == 1) ripeTomato.add(new int[] {h, m, n});
				}
			}
		}
		
		if(raw == 0) System.out.println(0);
		else {
			while(!ripeTomato.isEmpty()) {
			    // 현재 큐에 있는 것들(같은 날)을 한 번에 처리
			    int size = ripeTomato.size();
			    boolean possible = false;
			    
			    for(int s=0; s<size; s++) {
			        int[] now = ripeTomato.poll();
			        
			        for(int i=0; i<6; i++) {
			            int nh = now[0] + dh[i];
			            int nm = now[1] + dm[i];
			            int nn = now[2] + dn[i];
			            
			            // 범위 체크
			            if(nh<0 || nh>=H || nm<0 || nm>=M || nn<0 || nn>=N) continue;
			            
			            // 1은 이미 익은 토마토, -1은 토마토가 없음
			            if(storage[nh][nm][nn] != 0) continue;
			            
			            // storage[nh][nm][nn] == 0 인 경우에만 동작
			            // 익지 않은 토마토인 경우 토마토 익히고
			            // 익지 않은 토마토 수 줄이고
			            // 날짜 추가를 위한 possible = true로 변경
			            // 다음 queue에 저장
			            storage[nh][nm][nn] = 1;
			            raw--;
			            possible = true;
			            ripeTomato.add(new int[] {nh, nm, nn});
			        }
			    }
			    
			    if(possible) day++;
			}
			
			if (raw == 0)
				System.out.println(day);
			else
				System.out.println(-1);
		}
	}
}