import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int tc, n, cnt, result=Integer.MAX_VALUE;
	public static int[][] arr;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int T=1; T<=tc; T++) {
			result=Integer.MAX_VALUE;
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Solution(0, 0);
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void Solution(int k, int idx) {
		if(k==n/2) {
			int sum1=0, sum2=0;
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					if(visit[i] && visit[j]) {
						sum1+=arr[i][j]+arr[j][i];
					}
					else if(!visit[i] && !visit[j]) {
						sum2+=arr[i][j]+arr[j][i];
					}
				}
			}
			result = Math.min(result, Math.abs(sum1-sum2));
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if(!visit[i]) {
				visit[i]=true;
				Solution(k+1, i+1);
				visit[i]=false;
			}
		}
	}
}