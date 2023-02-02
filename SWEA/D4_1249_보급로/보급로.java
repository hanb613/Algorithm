import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int n;
	static int[][] arr;
	static int[][] cost;
	
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int TC=1; TC<=t; TC++) {
		
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			cost = new int[n][n];
			
			for (int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = str.charAt(j)-'0';	
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Solution();
			
			System.out.println(String.format("#%d %d", TC,  cost[n-1][n-1]));
		}		
	}
	
	public static void Solution() {
		Queue<Pair> q = new LinkedList<Pair>();
		Pair cur = new Pair();
		q.add(new Pair(0, 0));
		cost[0][0]=arr[0][0];
		
		while(!q.isEmpty()) {
			cur = q.remove();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				
				if(cost[nx][ny] > arr[nx][ny]+cost[cur.x][cur.y]) {
					cost[nx][ny] = arr[nx][ny]+cost[cur.x][cur.y];
					q.add(new Pair(nx, ny));
				}
			}
		}
		return;
	}
	
	public static class Pair{
		int x, y, dist;
		Pair(){ }
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
