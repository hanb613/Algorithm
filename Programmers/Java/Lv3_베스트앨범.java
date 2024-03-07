import java.util.*;

class Solution {
    
    static HashMap<String, Integer> cntMap = new HashMap<>(); // 장르별 총 재생 횟수
    static HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 <idx, 재생횟수>
    
    static ArrayList<Integer> result = new ArrayList<>();
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        for(int i=0; i<genres.length; i++) {
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!music.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);                
            } else {
                music.get(genres[i]).put(i, plays[i]);
            }
        }
        
        // 많이 재생된 장르 정렬 - value를 기준
        List<String> keySet = new ArrayList<>(cntMap.keySet());
        keySet.sort((o1, o2) -> cntMap.get(o2) - cntMap.get(o1));

        for(String key : keySet){
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genresKey = new ArrayList<>(map.keySet());
            
            genresKey.sort((o1, o2) -> map.get(o2) - map.get(o1));
            
            // 상위 1~2곡 담기
            result.add(genresKey.get(0));
            if(genresKey.size() >= 2){
                result.add(genresKey.get(1));
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}