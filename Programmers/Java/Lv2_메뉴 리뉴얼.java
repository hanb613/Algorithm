import java.util.*;
import java.util.Map.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> answer = new ArrayList<>();
    static char[][] charArr;
    
    static private void combi(StringBuilder stb, int idx, int nowCnt, int strNum, int endLength){
        if(nowCnt == endLength){
            map.put(stb.toString(), map.getOrDefault(stb.toString(), 0) + 1);
            return;
        }
        
        for(int i=idx; i<charArr[strNum].length; i++){
            stb.append(charArr[strNum][i]);
            combi(stb, i+1, nowCnt+1, strNum, endLength);
            stb.delete(nowCnt, nowCnt+1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] result = {};
        
        charArr = new char[orders.length][];
        
        for(int i=0; i<orders.length; i++){
            // orders -> char 배열에 저장 후 오름차순 정렬
            charArr[i] = orders[i].toCharArray();
            Arrays.sort(charArr[i]);
        }
        
        for(int i=0; i<course.length; i++){
            
            int max = -1;
            
            for(int j=0; j<orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                combi(sb, 0, 0, j, course[i]); // 조합
            }
            
            // 해당 course에 맞는 조합 중 최대 값 찾기
            for(Entry<String, Integer> entrySet : map.entrySet()) {
                if(entrySet.getKey().length() == course[i]){
                    max = Math.max(max, entrySet.getValue());
                }
            }

            // 조건에 맞는지 확인
            for(Entry<String, Integer> entrySet : map.entrySet()) {
                if(max == entrySet.getValue() && entrySet.getKey().length() == course[i] && max>=2){
                    if(!answer.contains(entrySet.getKey())) {
                        answer.add(entrySet.getKey());
                    }
                }
            }
        }
        
        // 정답 오름차순 정렬
        Collections.sort(answer);
        
        result = answer.toArray(new String[answer.size()]);
        
        return result;
    }
}