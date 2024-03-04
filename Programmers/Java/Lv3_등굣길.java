import java.util.*;

class Solution {
    
    static int[][] arr;
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        arr = new int[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++){
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        arr[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(arr[i][j] == -1) continue;
                if(arr[i-1][j] > 0) arr[i][j] += (arr[i-1][j]%MOD);
                if(arr[i][j-1] > 0) arr[i][j] += (arr[i][j-1]%MOD);
            }
        }
        
        answer = arr[n][m] % MOD;
        
        return answer;
    }
}