import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            int startP = find(costs[i][0]);
            int endP = find(costs[i][1]);
            
            if(startP == endP) continue;
            
            answer+=costs[i][2];
            parent[startP] = endP;
        }
                
        return answer;
    }
    
    private static int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
}