import java.util.*;

class Solution {
    
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> ret = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] relation) {

        n = relation[0].length; // col
        
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            DFS(0, 0, i+1, relation);
        }
        
        return ret.size();
    }
    
    private static void DFS(int start, int depth, int end, String[][] relation){
        if(depth == end) {
            String key = "";
            list.clear();
            map.clear();
            
            for(int i=0; i<n; i++){
                if(visited[i]){
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            
            // 조합 만들고 존재하는지 확인
            // 100ryan, 200apeach
            for(int i=0; i<relation.length; i++){
                String str = "";
                
                for(Integer j : list){
                    str += relation[i][j];
                }
                
                if(map.containsKey(str)) return;
                map.put(str, 0);
            }
            
            // 후보키 
            for(String s : ret){
                int cnt = 0;
                
                for(int i=0; i<key.length(); i++){
                    String str = String.valueOf(key.charAt(i));
                    if(s.contains(str)) cnt++;
                }
                
                if(cnt==s.length()) return;
            }
            
            ret.add(key);
            
            return;
        }
        
        for(int i=start; i<n; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            DFS(i, depth+1, end, relation);
            visited[i] = false;
        }
        
    }
}