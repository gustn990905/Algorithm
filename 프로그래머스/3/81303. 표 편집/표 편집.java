import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        // 초기 연결 리스트 세팅
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        int cur = k;

        for (String command : cmd) {
            char op = command.charAt(0);

            if (op == 'U' || op == 'D') {
                int x = Integer.parseInt(command.split(" ")[1]);

                if (op == 'U') {
                    for (int i = 0; i < x; i++) {
                        cur = prev[cur];
                    }
                } else {
                    for (int i = 0; i < x; i++) {
                        cur = next[cur];
                    }
                }

            } else if (op == 'C') {
                stack.push(cur);
                removed[cur] = true;

                int p = prev[cur];
                int nNode = next[cur];

                if (p != -1) next[p] = nNode;
                if (nNode != -1) prev[nNode] = p;

                cur = (nNode != -1) ? nNode : p;

            } else { // Z
                int restore = stack.pop();
                removed[restore] = false;

                int p = prev[restore];
                int nNode = next[restore];

                if (p != -1) next[p] = restore;
                if (nNode != -1) prev[nNode] = restore;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(removed[i] ? 'X' : 'O');
        }

        return sb.toString();
    }
}