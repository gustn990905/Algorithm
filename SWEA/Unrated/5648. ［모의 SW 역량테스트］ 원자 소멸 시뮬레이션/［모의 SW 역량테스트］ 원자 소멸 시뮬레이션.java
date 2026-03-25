import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // 원자 정보
    static class Atom {
        int r, c; // 위치
        int d;    // 방향
        int k;    // 에너지

        public Atom(int r, int c, int d, int k) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.k = k;
        }
    }

    // 방향: 0->우, 1->좌, 2->상, 3->하
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            List<Atom> atoms = new ArrayList<>();

            int offset = 1000;

            // -------------------------------
            // 입력
            // -------------------------------
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int d = sc.nextInt();
                int k = sc.nextInt();

                // 좌표 변환
                // 음수 제거 -> offset
                // 중간 충돌 처리 -> 좌표 2배
                int r = 2 * (x + offset);
                int c = 2 * (y + offset);

                atoms.add(new Atom(r, c, d, k));
            }

            int result = 0;

            // -------------------------------
            // 시뮬레이션
            // -------------------------------
            for (int time = 0; time <= 4000; time++) {

                // 1. 이동
                List<Atom> moved = new ArrayList<>();

                for (Atom a : atoms) {
                    int nr = a.r + dr[a.d];
                    int nc = a.c + dc[a.d];

                    // 범위 밖 -> 소멸
                    if (nr < 0 || nr > 4000 || nc < 0 || nc > 4000) continue;

                    a.r = nr;
                    a.c = nc;

                    moved.add(a);
                }

                // 전부 사라지면 종료
                if (moved.isEmpty()) break;

                // 2. 정렬
                // (r, c) 기준 -> 같은 좌표끼리 붙게 됨
                Collections.sort(moved, (a, b) -> {
                    if (a.r == b.r) return a.c - b.c;
                    return a.r - b.r;
                });

                // 3. 충돌 처리
                List<Atom> next = new ArrayList<>();

                int i = 0;

                while (i < moved.size()) {

                    Atom cur = moved.get(i);

                    int sum = cur.k; // 에너지 합
                    int count = 1;   // 개수

                    int j = i + 1;

                    // 같은 좌표 찾기
                    while (j < moved.size() &&
                           moved.get(j).r == cur.r &&
                           moved.get(j).c == cur.c) {

                        sum += moved.get(j).k;
                        count++;
                        j++;
                    }

                    // 충돌 처리
                    // count > 1 -> 모두 소멸 + 에너지 누적
                    // count == 1 -> 생존
                    
                    if (count > 1) {
                        result += sum;
                    } else {
                        next.add(cur);
                    }

                    // 다음 그룹으로 이동
                    // i 하나씩 증가 X -> 그룹 단위 점프
                    i = j;
                }

                atoms = next;

                // 더 이상 없으면 종료
                if (atoms.isEmpty()) break;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}