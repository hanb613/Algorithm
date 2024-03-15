import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, island, time;
	static int[][] arr;
	static boolean[][] visitedG, visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
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
					time++;
					
					BFS(i, j);
					
					if(coutIsland()) {
						System.out.println(time);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
	
	// 빙산 녹이는 메서드
	private static void BFS(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		visitedG = new boolean[n][m];
		
		q.add(new Info(x, y));
		visitedG[x][y] = true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			int cnt = 0;
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!visitedG[nx][ny] && arr[nx][ny]==0) cnt++; // 주변에 바다일 때
					if(!visitedG[nx][ny] && arr[nx][ny]!=0) {
						q.add(new Info(nx, ny));
						visitedG[nx][ny] = true;
					}
				}
			}

			arr[p.x][p.y]-=cnt;
			if(arr[p.x][p.y] < 0) {
				arr[p.x][p.y]=0;
			}
		}
	}
	
	// 빙산 덩어리 개수 세는 메서드 (1)
	private static boolean coutIsland() {

		visited = new boolean[n][m];
		island = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]!=0 && !visited[i][j]) {
					DFS(i, j, visited);
					island++; // 덩어리 +1
				}
			}
		}

		if(island >= 2) return true; // 두 덩어리 이상이면 return 
		return false;
	}
	
	// 빙산 덩어리 개수 세는 메서드 (2)
	private static void DFS(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			
			if(arr[nx][ny]!=0 && !visited[nx][ny]) {
				DFS(nx, ny, visited);
				
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