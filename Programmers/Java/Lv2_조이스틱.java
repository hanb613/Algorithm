class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int idx=0;
        int move = name.length()-1;
        
        for(int i=0; i<name.length(); i++){
            answer+=Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i) + 1); // 위,아래 최소 움직임
            
            // 연속된 알파벳 'A'가 끝나는 지점의 인덱스
            idx = i+1;
            while(idx<name.length() && name.charAt(idx) == 'A'){
                idx++;
            }
            
            // 왼,오 최소 움직임
            move = Math.min(move, i*2 + (name.length()-idx)); // 오른쪽으로 갔다가 다시 왼쪽으로 
            move = Math.min(move, (name.length()-idx)*2 + i); // 마지막 위치로 이동해서 뒷부분 변경 -> 다시 오른쪽으로 시작위치로 이동 -> 변경
        }
        
        return answer + move;
    }
}