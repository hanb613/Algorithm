import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n, result;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[31][31];
		dp[1][0] = 1;
		dp[2][0] = 2;
		dp[3][0] = 5;
		
		solve(30, 0);
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			System.out.println(dp[n][0]);
		}
	}
	
	private static long solve(int W, int H) {
		if(W==0) return 1; // 반알만 남아있으면 
		if(dp[W][H]!=0) return dp[W][H]; // 계산 했으면
		
		if(W!=0) { // 한알이 있으면 한알 꺼냄 => 반 자르기
			dp[W][H] += solve(W-1, H+1);
		}
		if(H!=0) { // 반알이 있으면 반알 꺼냄
			dp[W][H] += solve(W, H-1);
		}
		
		return dp[W][H];
	}
}
