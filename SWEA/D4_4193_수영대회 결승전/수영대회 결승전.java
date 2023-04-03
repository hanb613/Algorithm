import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int tc, n, result; 
	static int a,b, c,d;
	static int[][] arr, tmp;
	static boolean[][] visit;
	static ArrayList<Info> list;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc=Integer.parseInt(br.readLine());
		
		for(int T=1; T<=tc; T++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			visit=new boolean[n][n];
			
			result=Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			c=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			
			if(solve())
				System.out.println(String.format("#%d %d", T, result));
			else 
				System.out.println(String.format("#%d %d", T, -1));
		}
	}
	
	private static boolean solve() {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(a, b, 0));
		visit[a][b]=true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				
				if(nx==c && ny==d) {
					result = p.cnt+1;
					return true;
				}
				
				if(arr[nx][ny]==1 || visit[nx][ny]) continue;
				if(arr[nx][ny]==2) { 
					if(p.cnt%3==2) {
						visit[nx][ny]=true;
						q.offer(new Info(nx, ny, p.cnt+1));
					} else {
						visit[p.x][p.y]=true;
						q.offer(new Info(p.x, p.y, p.cnt+1));
					}
				} else {
					visit[nx][ny]=true;
					q.offer(new Info(nx, ny, p.cnt+1));
				}
			}
		}
		
		return false;
	}
	
	private static class Info{
		int x, y, cnt;

		public Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}
	}
}
