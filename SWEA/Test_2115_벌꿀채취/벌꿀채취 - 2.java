import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, n, m, c, result;
	static int[][] arr;
	static int[] maxVal, honey, start;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine().trim());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			start = new int[2]; // 일꾼 A, B 시작 위치
			result=0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(0, 0);
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}

	private static void combi(int k, int num) {
		if(k==2) {
			honey = new int[m];
			maxVal = new int[2];
			
			int idx = start[0];
			for(int i=0; i<m; i++) {
				honey[i] = arr[idx/n][(idx%n)+i];
			}
			
			subset(0, 0, 0, 0); // 일꾼 A
			
			idx = start[1];
			for(int i=0; i<m; i++) {
				honey[i] = arr[idx/n][(idx%n)+i];
			}
			
			subset(1, 0, 0, 0); // 일꾼 B
			
			result = Math.max(result, maxVal[0]+maxVal[1]);
			return;
		}
		
		if(num > (n*n)-m) return;
		
		if(num%n <= n-m) {
			start[k] = num;
			combi(k+1, num+m);
		}
		
		combi(k, num+1);
	}
	
	private static void subset(int num, int cnt, int sum, int total) {
		if(sum>c) return;
		
		if(cnt == m) {
			maxVal[num] = Math.max(maxVal[num], total);
			return;
		}
		
		subset(num, cnt+1, sum+honey[cnt], total+(honey[cnt]*honey[cnt]));
		subset(num, cnt+1, sum, total);
	}
}