import java.util.*;
import java.io.*;

public class Main {

	static int n, result;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
        
		arr = new int[n];
		dp = new int[n][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = dp[0][1] = arr[0];

		result = dp[0][0];
		
		for(int i=1; i<n; i++){
            dp[i][0] = Math.max(arr[i], dp[i-1][0]+arr[i]); // 숫자 제거 없이 만든 max
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]); // 숫자 하나 제거해서 만든 max
            
        	result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
		
        System.out.println(result);
	}
}