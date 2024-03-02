import java.util.*;

class Solution {
    
    static HashMap<Integer, Integer> map1 = new HashMap<>();
    static HashMap<Integer, Integer> map2 = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        
        for(int t : topping){
            map1.put(t, map1.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            map2.put(t, map2.getOrDefault(t, 0) + 1);
            map1.put(t, map1.get(t) - 1);
            
            if(map1.get(t) == 0){
                map1.remove(t);
            } 
            
            if(map1.size() == map2.size()) answer++;
            
        }
        
        return answer;
    }
}