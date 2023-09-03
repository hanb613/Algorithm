import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        
        HashSet<String> total = new HashSet<>();
        HashMap<String, Integer> gemNum = new HashMap<>();
        Queue<String> cur = new LinkedList<>();
        
        int left = 0, start = 0;
        int length = 987654321;
        
        for(int i=0; i<gems.length; i++){
            total.add(gems[i]);
        }

        for(int i=0; i<gems.length; i++){
            if(!gemNum.containsKey(gems[i])){
                gemNum.put(gems[i], 1);
            } else {
                gemNum.put(gems[i], gemNum.get(gems[i])+1);
            }
            
            cur.add(gems[i]);
            
            while(true) { // 중복 보석 제거
                String p = cur.peek();
                
                if(gemNum.get(p) > 1){
                    gemNum.put(p, gemNum.get(p)-1);
                    cur.poll();
                    left++;
                }
                else break;
            }

            if(total.size() == gemNum.size() && length > cur.size()) { // 모든 보석 + 길이 더 작으면 갱신
                start = left;
                length = cur.size();
            }
        }

        return new int[] { start + 1, start + length };
    }
}