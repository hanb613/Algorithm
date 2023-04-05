import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, result;
	static int[][] arr, num;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		String str="";
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		solve(0, 0);
	}	
	
	private static void solve(int x, int y) {
		Deque<Info> q = new LinkedList<Info>();
		q.offer(new Info(x, y, 0));
		visit[x][y]=true;

		while(!q.isEmpty()) {
			Info p=q.poll();
			
			if(p.x==n-1 && p.y==m-1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || visit[nx][ny]) continue;
				
				visit[nx][ny]=true;
				if(arr[nx][ny]==0) {
					q.addFirst(new Info(nx, ny, p.cnt));					
				} else {
					q.addLast(new Info(nx, ny, p.cnt+1));	
				}
			}
		}
		
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