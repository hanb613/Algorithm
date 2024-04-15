import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> list;
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int cnt : list) {
            if(k<=0) break;
            
            answer++;
            k-=cnt;
        }
        
        return answer;
    }
    
}