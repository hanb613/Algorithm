class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
        
        int[] dp = new int[n]; // 첫번째 집 털기
        int[] dp2 = new int[n]; // 첫번째 집 털기 X
        
        dp[0] = dp[1] = money[0];
        
        dp2[0] = 0;
        dp2[1] = money[1];  
        
        for(int i=2; i<n; i++){
            // 현재 집 털기 X, 현재 집 털기 O
            dp[i] = Math.max(dp[i-1], money[i] + dp[i-2]);
            dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
        }
        
        // 첫번째 집 털면 마지막 집 X
        return Math.max(dp[n-2], dp2[n-1]);
    }
}