import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=tc; TC++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[]arr = new int[n];
			int[]dp = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result=0; 
			for(int i=0; i<n; i++) {
				dp[i]=1; // 자기 자신 -> 1
				for(int j=0; j<i; j++) { // 나보다 앞에 위치하고
					if(arr[j]<arr[i]) { // 나보다 작은 값 중에
						dp[i] = Math.max(dp[i], dp[j]+1); // 가장 큰 수
					}
				}
				result = Math.max(result, dp[i]);
			}

			System.out.println(String.format("#%d %d", TC, result));
			
		}
	}
}
