import java.util.*;
import java.io.*;

public class Main {

	static int n, m, move, result;
	static int[][] arr, load;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]!=0) {
					visited = new boolean[n][m];
					BFS(i, j);
				}
			}
		}
		
        System.out.println(result);
	}
	
	private static void BFS(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(x, y, 0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			int nowMove = p.dist; 
			int sum = arr[x][y] + arr[p.x][p.y]; // 시작 + 끝
				
			if(nowMove==move) { // 이동한 거리가 같으면 -> result = 시작+끝이 더 큰거
				result = Math.max(result, sum);
				move = nowMove;
			} else if(nowMove>move){ // 가장 긴 경로 -> result = 시작+끝
				result = sum;
				move = nowMove;
			}

			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0|| nx>=n || ny>=m) continue;
				if(visited[nx][ny] || arr[nx][ny]==0) continue;
				
				q.offer(new Info(nx, ny, p.dist+1));
				visited[nx][ny] = true;
			}
		}
	}
	
	private static class Info{
		int x, y, dist;
		
		public Info(int x, int y, int dist) {
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
	}
}