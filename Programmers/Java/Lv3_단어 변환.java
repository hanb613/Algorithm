import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        DFS(0,begin, target, words);
        
        return answer;
    }
    
    public static void DFS(int cnt, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (!visited[i]){ 
            
                int k = 0; 
                for (int j=0; j<begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        k++;
                    }
                }

                if (k == begin.length()-1) {  // 글자 1개만 다름
                    visited[i] = true;
                    DFS(cnt+1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }
    }
}