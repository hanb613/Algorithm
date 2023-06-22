import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void DFS(int k, int[][] computers){
        visited[k] = true;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i] && computers[k][i]==1){
                DFS(i, computers);
            }
        }
    }
}