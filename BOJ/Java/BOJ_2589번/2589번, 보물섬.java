import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, result;
	static char[][] arr;
	static int[][] cnt;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		

		String s="";
		for(int i=0; i<r; i++) {
			s = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j]=='L') {
					visit = new boolean[r][c];
					solve(i, j);
				}
			}
		}
		
		System.out.println(result);
	
	}
	
	private static void solve(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(x, y, 0));
		visit[x][y]=true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx=p.x+dx[d];
				int ny=p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
				if(arr[nx][ny]=='W' || visit[nx][ny]) continue;
				
				visit[nx][ny]=true;
				result = Math.max(result, p.cnt+1);
				q.offer(new Info(nx, ny, p.cnt+1));
			}
		}
	}
	
	private static class Info{
		int x, y, cnt;

		public Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		} 
	}
}