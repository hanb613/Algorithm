import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String newStr = s;
        for(int i=0; i<s.length(); i++){
            if(isRight(newStr)) { // 올바른 괄호 문자열
                answer++;
            }
            
            // 왼쪽으로 한 칸 회전
            newStr = newStr.substring(1, newStr.length()) + newStr.charAt(0);
        }
            
        
        return answer;
    }
    
    // 올바른 괄호 문자열인지 판단
    private static boolean isRight(String str){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            switch(str.charAt(i)){
                case '{' :
                    st.add('{');
                    break;
                case '[' :
                    st.add('[');
                    break;
                case '(' :
                    st.add('(');
                    break;

                case '}' :
                    if(st.isEmpty() || st.peek()!='{') return false;
                    st.pop(); 
                    break;
                case ']' :
                    if(st.isEmpty() || st.peek()!='[') return false;
                    st.pop(); 
                    break;
                case ')' :
                    if(st.isEmpty() || st.peek()!='(') return false;
                    st.pop(); 
                    break;
            }
        }
        
        if(st.isEmpty()) return true;
        else return false;
    }
}