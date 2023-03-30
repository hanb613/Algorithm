import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, result=Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[n];
		visit[0]=true;
		solve(0, 0, 0, 0);
		
		System.out.println(result);
	}
	
	private static void solve(int k, int start, int sum, int cnt) { 
		if(result<sum) return;
		
		if(cnt==n-1) {
			if(arr[k][start]!=0) {
				sum+=arr[k][start];
				result=Math.min(result, sum); // 최솟값 갱신		
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(arr[k][i]>0 && !visit[i]) { // 비용이 있고, 방문하지 않았으면 => 도시 방문
				visit[i]=true;
				solve(i, start, sum+arr[k][i], cnt+1);
				visit[i]=false;
			}
		}
		
	}
}
