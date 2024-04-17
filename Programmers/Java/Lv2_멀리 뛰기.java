class Solution {
    
    static final int MOD = 1234567;
    
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<2001; i++) { 
            dp[i] = (dp[i-1] + dp[i-2])%MOD;
        }
        
        answer = dp[n];
        return answer;
    }
}