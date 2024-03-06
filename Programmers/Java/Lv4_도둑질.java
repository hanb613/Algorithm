class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
        
        int[] dp = new int[n]; // ù��° �� �б�
        int[] dp2 = new int[n]; // ù��° �� �б� X
        
        dp[0] = dp[1] = money[0];
        
        dp2[0] = 0;
        dp2[1] = money[1];  
        
        for(int i=2; i<n; i++){
            // ���� �� �б� X, ���� �� �б� O
            dp[i] = Math.max(dp[i-1], money[i] + dp[i-2]);
            dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
        }
        
        // ù��° �� �и� ������ �� X
        return Math.max(dp[n-2], dp2[n-1]);
    }
}