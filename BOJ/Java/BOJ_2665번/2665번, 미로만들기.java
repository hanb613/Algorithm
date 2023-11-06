import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] arr, distance;
	
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		distance = new int[n][n];
		
		String str;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j)-'0';
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		BFS();

        System.out.println(distance[n-1][n-1]);
	}
	
	private static void BFS() {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(0, 0));
		distance[0][0] = 0;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(distance[nx][ny] <= distance[p.x][p.y]) continue;
				
				if(arr[nx][ny]==1) { // 흰방
					distance[nx][ny] = distance[p.x][p.y];
				} else { // 검은방 -> 흰색으로 
					distance[nx][ny] = distance[p.x][p.y]+1;					
				}
				q.offer(new Info(nx, ny));
			}
		}
	}
	
	private static class Info{
		int x, y;
		
		public Info(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
}