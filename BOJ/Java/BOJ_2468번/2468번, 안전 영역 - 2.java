import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, result=1, sum, minHeight=100, maxHeight;
	static int[][] arr;
	static boolean[][] visit;
	static Queue<Info> q = new LinkedList<Info>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, arr[i][j]);
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}
		
		for(int h=minHeight; h<=maxHeight; h++) {
			visit = new boolean[n][n];
			sum=0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j] && arr[i][j]>h) {
						sum++;
						BFS(i, j, h);
					}
				}
			}
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
	}
	
	private static void BFS(int x, int y, int height) {
		q.clear();
		visit[x][y]=true;
		q.add(new Info(x, y));
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n || visit[nx][ny]) continue;
				if(arr[nx][ny]<=height) {
					visit[nx][ny]=true;
					continue;
				}
				
				visit[nx][ny]=true;
				q.add(new Info(nx, ny));
			}
		}
	}
	
	private static class Info{
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
