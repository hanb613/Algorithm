import java.util.*;
import java.io.*;

public class Main {

	static String str;
	static long[] dp;
	static final int MOD = 1000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		str = br.readLine();
		
		long[] dp = new long[str.length()+1];
		
		if(str.charAt(0) == '0') {
			System.out.println(0);
		} else {
			dp[0]=dp[1]=1;
			
			for(int i=2; i<=str.length(); i++) {
				char now = str.charAt(i-1);
				char prev = str.charAt(i-2);
				if(now == '0') { // 현재 위치가 0이면 ? 앞에 1이나 2가 와야됨
					if(prev=='1' || prev=='2') {
						dp[i] = dp[i-2] % MOD;
					} else {
						break;
					}
				} else {
					int result = Integer.parseInt(str.substring(i-2, i));

					if(result>=27 || result<=9) {
						dp[i] = dp[i-1] % MOD;
					}else {
						dp[i] = (dp[i-1]+dp[i-2]) % MOD;
					}
				}
			}
			
			System.out.println(dp[str.length()] % MOD);
		}
	
	}
}