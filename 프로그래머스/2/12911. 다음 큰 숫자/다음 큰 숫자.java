class Solution {
    public int solution(int n) {
        // n을 2진수로 바꿨을 때의 1의 개수
        String n2 = Integer.toString(n, 2);
        int cnt2 = 0;
        for(int i=0; i<n2.length(); i++) {
            if(n2.charAt(i) == '1') cnt2++;
        }

        boolean find = false;

        int num = n;
        while(!find) {
            // 조건 1
            num++;

            // 조건 2
            String num2 = Integer.toString(num, 2);
            int cntNum2 = 0;
            for(int i=0; i<num2.length(); i++) {
                if(num2.charAt(i) == '1') cntNum2++;
            }

            if(cnt2 == cntNum2) find = true;
        }

        return num;
    }
}