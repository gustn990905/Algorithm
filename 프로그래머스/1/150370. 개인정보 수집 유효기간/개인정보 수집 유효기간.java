import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	static int convertToDays(String date) {
		String[] split = date.split("\\.");
		
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		
		return year*12*28 + month*28 + day;
	}
	
    public int[] solution(String today, String[] terms, String[] privacies) {
    	// 오늘 날짜를 총 일수로 변환
    	int todayDays = convertToDays(today);
    	
    	// 약관 종류별 유효기간 저장
    	Map<String, Integer> termMap = new HashMap<>();
    	
    	for(String term : terms) {
    		String[] split = term.split(" ");
    		
    		String type = split[0];
    		int month = Integer.parseInt(split[1]);
    		
    		termMap.put(type, month);
    	}
    	
    	// 파기해야 하는 개인정보 번호 저장
    	List<Integer> result = new ArrayList<>();
    	
    	for(int i=0; i<privacies.length; i++) {
    		String[] split = privacies[i].split(" ");
    		
    		String date = split[0];
    		String type = split[1];
    		
    		// 개인정보 수집 날짜를 총 일수로 변환
    		int privacyDate = convertToDays(date);
    		
    		// 해당 약관의 유효기간
    		int termMonth = termMap.get(type);
    		
    		// 개인 정보를 파기해야 하는 날짜
    		int destroyDate = privacyDate + termMonth*28;
    		
    		// 오늘이 파기 날짜와 같거나 이후이면 파기
    		if(todayDays >= destroyDate) {
    			result.add(i + 1);
    		}
    	}
    	
    	int[] answer = new int[result.size()];
    	
    	for(int i=0; i<result.size(); i++) {
    		answer[i] = result.get(i);
    	}
    	
        return answer;
    }
}