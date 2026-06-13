class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        // arr1안의 숫자를 2진수로 변경
        String[] arr1_2 = new String[arr1.length];
        for(int i=0; i<arr1.length; i++) {
        	arr1_2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i]).replace(' ', '0'));
        }
        
        // arr2안의 숫자를 2진수로 변경
        String[] arr2_2 = new String[arr2.length];
        for(int i=0; i<arr2.length; i++) {
        	arr2_2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr2[i]).replace(' ', '0'));
        }
        
        // arr1과 arr2를 비교해서 1이 하나라도 있으면 # 출력
        for(int i=0; i<arr1.length; i++) {
        	String result = "";
        	for(int j=0; j<n; j++) {
        		if(arr1_2[i].charAt(j) == '1' || arr2_2[i].charAt(j) == '1') result += "#";
        		else result += " ";
        	}
        	answer[i] = result;
        }
        
        return answer;
    }
}