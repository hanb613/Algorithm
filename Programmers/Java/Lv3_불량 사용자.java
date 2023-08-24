import java.util.*;
 
class Solution {
    
    static HashSet<String> set;
    static String[] regex;
    static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        regex = new String[banned_id.length];
        visited = new boolean[user_id.length];
        set = new HashSet<>();
        
        for(int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }
        
        solve(0, "", user_id);
        
        return set.size();
    }
    
    public void solve(int k, String result, String[] user_id) {
        if(k == regex.length) {
            String[] arr = result.split(" ");
            Arrays.sort(arr);
            
            String str = "";
            for(int i = 0; i < arr.length; i++) {
                str += arr[i];
            }
            
            set.add(str);
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i] && user_id[i].matches(regex[k])) {
                visited[i] = true;
                solve(k + 1, result + " " + user_id[i], user_id);
                visited[i] = false;
            }
        }
    }
}
