class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // targets의 모든 문자 확인
        for(int i=0; i<targets.length; i++) {
            int sum = 0; // 총합
            for(int j=0; j<targets[i].length(); j++) {
                char target = targets[i].charAt(j);

                int cnt = Integer.MAX_VALUE;
                for(int k=0; k<keymap.length; k++) {
                    for(int l=0; l<keymap[k].length(); l++) {
                        // 키캡의 같은 문자를 만나면
                        if(target == keymap[k].charAt(l)) {
                            cnt = Math.min(cnt, l+1);
                            break;
                        }
                    }
                }
                if(cnt == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                else sum += cnt;
            }
            answer[i] = sum;
        }

        return answer;
    }
}