import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
     
	static int tc, n, x, result;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			result=0;			
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<n; i++) {
				if(solveRow(i)) result++;
				if(solveCol(i)) result++;
			}
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}


	private static boolean solveRow(int k) {
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<n-1; i++) {
			if(arr[k][i] == arr[k][i+1]) continue;
			else if(Math.abs(arr[k][i]-arr[k][i+1])>=2) return false; // 현재 칸과 다음칸의 차이가 2이상이면 X
			else if(arr[k][i]-arr[k][i+1] == 1) { // 내려가는 경사
				for(int j=i+1; j<=i+x; j++) {
					if(j>=n || visit[j]) return false; // 방문 했거나 범위 벗어나면 X
					if(arr[k][i+1]!=arr[k][j]) return false; // x만큼의 다음칸이 다르면 X
					visit[j]=true;
				}
			}
			else if(arr[k][i]-arr[k][i+1] == -1) { // 올라가는 경사
				for(int j=i; j>i-x; j--) {
					if(j<0 || visit[j]) return false; // 방문 했거나 범위 벗어나면 X
					if(arr[k][i]!=arr[k][j]) return false; // 현재칸과 x만큼의 이전칸이 다르면 X
					visit[j]=true;
				}
			}
		}
		
		return true;
	}

	private static boolean solveCol(int k) {
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<n-1; i++) {
			if(arr[i][k] == arr[i+1][k]) continue;
			else if(Math.abs(arr[i][k]-arr[i+1][k])>=2) return false; // 현재 칸과 다음칸의 차이가 2이상이면 X
			else if(arr[i][k]-arr[i+1][k] == 1) { // 내려가는 경사
				for(int j=i+1; j<=i+x; j++) {
					if(j>=n || visit[j]) return false; // 방문 했거나 범위 벗어나면 X
					if(arr[i+1][k]!=arr[j][k]) return false; // x만큼의 다음칸이 다르면 X
					visit[j]=true;
				}
			}
			else if(arr[i][k]-arr[i+1][k] == -1) { // 올라가는 경사
				for(int j=i; j>i-x; j--) {
					if(j<0 || visit[j]) return false; // 방문 했거나 범위 벗어나면 X
					if(arr[i][k]!=arr[j][k]) return false; // 현재칸과 x만큼의 이전칸이 다르면 X
					visit[j]=true;
				}
			}
		}
		
		return true;
	}
}


