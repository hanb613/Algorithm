import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int n, l, result;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			if(rowSolve(i)) result++;
			if(colSolve(i)) result++;
		}
		
		System.out.println(result);
	}
	
	public static boolean rowSolve(int i) {
		boolean[] visit = new boolean[n];
		
		for(int j=0; j<n-1; j++) {
			if(arr[i][j] == arr[i][j+1]) continue;
			else if(Math.abs(arr[i][j] - arr[i][j+1])>=2) return false;
			else if(arr[i][j] - arr[i][j+1]==1) { // 내리막길
				for(int k=j+1; k<=j+l; k++) {
					if(k>=n || visit[k]) return false;
					if(arr[i][k]!=arr[i][j+1]) return false; // 칸 높이가 다르면 X, ex) 3 2 1 / 3 2 3 
					visit[k] = true;
				}
			}
			else if(arr[i][j] - arr[i][j+1] == -1) { // 오르막길
				for(int k=j; k>j-l; k--) {
					if(k<0 || visit[k]) return false;
					if(arr[i][j]!=arr[i][k]) return false; // 칸 높이가 다르면 X, ex) 1 2 3 / 2 3 2 / 1 2 2 3
					visit[k] = true;
				}
			}
		}
		return true;
	}
	
	public static boolean colSolve(int j) {
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<n-1; i++) {
			if(arr[i][j] == arr[i+1][j]) continue;
			
			else if(Math.abs(arr[i][j] - arr[i+1][j])>=2) return false;
			else if(arr[i][j] - arr[i+1][j]==1) {
				for(int k=i+1; k<=i+l; k++) {
					if(k>=n || visit[k]) return false;
					if(arr[k][j]!=arr[i+1][j]) return false;
					visit[k] = true;
				}
			}
			else if(arr[i][j] - arr[i+1][j] == -1) {
				for(int k=i; k>i-l; k--) {
					if(k<0 || visit[k]) return false;
					if(arr[i][j]!=arr[k][j]) return false;
					visit[k] = true;
				}
			}
		}
		return true;
	}
}