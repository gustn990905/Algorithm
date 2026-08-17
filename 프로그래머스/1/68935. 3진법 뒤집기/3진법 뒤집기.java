class Solution {
    public int solution(int n) {
        String num3 = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        
        return Integer.parseInt(num3, 3);
    }
}