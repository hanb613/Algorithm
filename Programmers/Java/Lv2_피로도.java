import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
        
    public int solution(int k, int[][] dungeons) {
        
        answer = -1;
        
        visited = new boolean[dungeons.length];
        
        solve(0, k, dungeons);
        
        return answer;
    }
    
    private static void solve(int k, int num, int[][] dungeons) {
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=num){
                visited[i] = true;
                solve(k+1, num - dungeons[i][1], dungeons);
                visited[i] = false;    
            }
        }
        
        answer = Math.max(answer, k);
    }
}