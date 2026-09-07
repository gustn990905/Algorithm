import javax.swing.event.TreeSelectionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[] nums;
    static Set<Integer> sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int tc = 1;

        while(tc <= T) {
            nums = new int[7];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int i=0;
            while(i < 7) {
                nums[i] = Integer.parseInt(st.nextToken());
                i++;
            }

            // 3개 숫자의 합을 저장할 TreeSet 생성
            // 큰 숫자부터 작은 숫자 순서로 내림차순 정렬
            sums = new TreeSet<>(Collections.reverseOrder());

            dfs(0, 0, 0);

            // sums에 들어있는 값을 하나씩 꺼내기 위한 Iterator
            Iterator<Integer> iterator = sums.iterator();

            // 5번째로 큰 값을 저장할 변수
            int answer = 0;

            // 몇 번째 값을 꺼냈는지 세기 위한 변수
            int count = 0;

            while(count < 5) {
                // 현재 값을 하나 꺼내서 answer에 저장
                answer = iterator.next();
                count++;
            }

            System.out.println("#" + tc + " " + answer);

            tc++;
        }
    }

    // idx : 현재 확인하고 있는 숫자
    static void dfs(int idx, int cnt, int sum) {
        // 숫자 3개 모두 고른 경우
        if(cnt == 3) {
            sums.add(sum);
            return;
        }

        // idx가 7이면 모든 숫자를 확인함
        if(idx == 7) return;

        // 현재 숫자를 선택하는 경우
        dfs(idx+1, cnt+1, sum + nums[idx]);
        
        // 현재 숫자를 선택하지 않음
        dfs(idx+1, cnt, sum);
    }
}