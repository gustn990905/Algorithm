import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] bomb = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= i + K && j < N; j++) {
                if (arr[i] == arr[j]) {
                    bomb[i] = true;
                    bomb[j] = true;
                }
            }
        }

        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (bomb[i]) {
                cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) + 1);
            }
        }

        int max = 0;
        int ans = 0;

        for (int key : cnt.keySet()) {
            if (cnt.get(key) > max) {
                max = cnt.get(key);
                ans = key;
            }
        }

        System.out.println(ans);
    }
}