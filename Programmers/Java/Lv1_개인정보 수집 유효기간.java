import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today, ".");
    
        int todayY = Integer.parseInt(st.nextToken()) * 28 * 12;
        int todayM = Integer.parseInt(st.nextToken()) * 28;
        int todayD = Integer.parseInt(st.nextToken());
        
        int total = todayY + todayM + todayD;
        
        // terms 배열 -> hashmap에 데이터 넣기
        for(int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0; i<privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            
            String date = st.nextToken();
            String privacy = st.nextToken();
            
            st = new StringTokenizer(date, ".");
            int privacyDay = (Integer.parseInt(st.nextToken()) * 28 * 12)
                            + (Integer.parseInt(st.nextToken()) * 28)
                            + (Integer.parseInt(st.nextToken()));
            
            
            int termDay = map.get(privacy) * 28; // 약관 종류에 따른 일자 계산
            
            if(privacyDay + termDay <= total) {
                answer.add(i+1);
            }
            
        }
        
        return answer;
    }
}