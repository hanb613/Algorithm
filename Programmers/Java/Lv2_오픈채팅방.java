import java.util.*;

class Solution {
    
    static HashMap<String, String> map = new HashMap<>();
    static ArrayList<String> ret = new ArrayList<>();
    static String first, userId;
    
    public String[] solution(String[] record) {
        String[] answer = {};
    
        StringTokenizer st;
        StringBuilder stb;
        
        for(int i=0; i<record.length; i++) {
            st = new StringTokenizer(record[i]);
                
            first = st.nextToken();
            userId = st.nextToken();
            
            if(first.equals("Enter")){
                map.put(userId, st.nextToken());
            } else if(first.equals("Change")) {
                map.replace(userId, st.nextToken());
            }
        }
        
        for(int i=0; i<record.length; i++){
            stb = new StringBuilder();
            st = new StringTokenizer(record[i]);
            
            first = st.nextToken();
            userId = st.nextToken();
            
            if(first.equals("Enter")){
                stb.append(map.get(userId)).append("님이 들어왔습니다.");
            } else if(first.equals("Leave")){
                stb.append(map.get(userId)).append("님이 나갔습니다.");
            } else continue;
            
            ret.add(stb.toString());
        }
        
        answer = ret.toArray(new String[ret.size()]);
        
        return answer;
    }
}