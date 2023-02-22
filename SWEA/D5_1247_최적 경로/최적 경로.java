import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int tc, n, result=Integer.MAX_VALUE, sum;
	public static int x, y;
	public static Pair company, home;
	public static Pair[] guest;
	
	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int T=1; T<=tc; T++) {
			n = Integer.parseInt(br.readLine());
			
			guest = new Pair[n];
			visit = new boolean[n];
			arr = new int[n];
			result=Integer.MAX_VALUE;
			
			st=new StringTokenizer(br.readLine());
			
			for(int i=0; i<n+2; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if(i==0) company = new Pair(x, y);
				else if(i==1) home = new Pair(x, y);
				else guest[i-2] = new Pair(x, y);
			}
			
			Solution(0, 0);
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void Solution(int k, int cnt) {
		if(cnt==n) {
			sum=0;
			
			for(int i=0; i<n+1; i++) {
				if(i==0) {
					sum+=Math.abs((company.x - guest[arr[i]].x)) + Math.abs((company.y - guest[arr[i]].y));
				}
				else if(i==n) {
					sum+=Math.abs((home.x - guest[arr[i-1]].x)) + Math.abs((home.y - guest[arr[i-1]].y));
				}
				else {
					sum+=Math.abs((guest[arr[i-1]].x - guest[arr[i]].x)) + Math.abs((guest[arr[i-1]].y - guest[arr[i]].y));
				}
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[k]=i;
				Solution(k+1, cnt+1);
				visit[i]=false;
			}
		}
	}
	
	private static class Pair{
		int x, y;
		
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}