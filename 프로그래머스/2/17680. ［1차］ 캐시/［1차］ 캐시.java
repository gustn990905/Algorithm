import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    	// 캐시 크기가 0이면 전부 miss
    	if(cacheSize == 0) return cities.length * 5;
    	
    	int time = 0;
    	
    	LinkedList<String> cache = new LinkedList<>();
    	
    	for(String city : cities) {
    		// 대소문자를 구분하지 않기 때문에
    		city = city.toLowerCase();
    		
    		if(cache.contains(city)) {
    			cache.remove(city);
    			cache.add(city);
    			time += 1;
    		}
    		
    		else {
    			// 캐시 꽉 차면 앞에서 제거
    			if(cache.size() == cacheSize) {
    				cache.removeFirst();
    			}
    			
    			cache.add(city);
    			time += 5;
    		}
    	}
      
        return time;
    }
}