import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1000001;
	
	static int n, num;
	static long[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new long[MAX];
		dp = new long[MAX];
		
		Arrays.fill(arr, 1);
		
		// 배수 성질 이용해서 약수의 합 구하기
		for(int i=2; i<MAX; i++) {
			for(int j=1; i*j<MAX; j++) {
				arr[i*j] += i;
			}
		}
		
		// x보다 작거나 같은 자연수의 합 => g(x)
		for(int i=1; i<MAX; i++) {
			dp[i]+=(dp[i-1] + arr[i]);
		}
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}