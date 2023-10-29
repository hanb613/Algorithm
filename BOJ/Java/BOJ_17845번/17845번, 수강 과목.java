import java.util.*;
import java.io.*;

public class Main {

	static int n, k;
	static int[] time, priority;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[k+1][n+1];
		time = new int[k+1];
		priority = new int[k+1];
		
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			priority[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				if(time[i]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]] + priority[i]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
        System.out.println(dp[k][n]);
	}
}