import java.io.*;
import java.util.*;

public class Main {

	static int c, n, result;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		dp = new int[c+101];
		result = Integer.MAX_VALUE;
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for(int j=customer; j<c+101; j++) {
				if (dp[j-customer] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], cost + dp[j-customer]);					
				}
			}
		}
		
		for(int i=c; i<c+101; i++) { // 적어도 c명 확보 -> dp[c]부터 탐색
			result = Math.min(result, dp[i]);
		}
		
		System.out.println(result);
		
	}
}