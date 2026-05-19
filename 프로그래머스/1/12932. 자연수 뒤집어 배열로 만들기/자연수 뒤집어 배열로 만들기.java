class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int size = num.length();
        
        int[] answer = new int[size];
        int idx=0;
        for(int i=size-1; i>=0; i--) {
        	answer[idx++] = num.charAt(i) - '0';
        }
        return answer;
    }
}