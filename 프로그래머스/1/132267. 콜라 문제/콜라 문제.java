class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int cola = n;
        
        while(cola >= a) {
        	answer += b*(cola / a);
        	n = cola - a*(cola/a) + b*(cola/a);
        	cola = n;
        }
        return answer;
    }
}