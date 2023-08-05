import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
	static int n;
	static long result;
	static int[] arr;
	static long[][] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        dp = new long[21][n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<21; i++) {
        	for(int j=0; j<n; j++) {
        		dp[i][j] = -1;
        	}
        }
        
        result = Solution(0, arr[0]);
        
        System.out.println(result);
       
    }
    
    private static long Solution(int k, int sum) {
    	
    	if(sum<0 || sum>20) return 0;
    	
    	if(k==n-2) {
    		if(sum==arr[n-1]) return 1;
    		return 0;
    	}
    	
    	if(dp[sum][k] != -1) return dp[sum][k];
    	
    	dp[sum][k] = 0;
    	dp[sum][k] += Solution(k+1, sum+arr[k+1]) + Solution(k+1, sum-arr[k+1]);
    	
    	return dp[sum][k]; 
    }
}
