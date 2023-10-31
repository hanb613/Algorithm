import java.util.*;
import java.io.*;

public class Main {

	static int n, k;
	static int s, x, y;
	static int[][] arr;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		for(int i=0; i<s; i++) {
			for(int j=1; j<=k; j++) {
				BFS(j);
				
				if(arr[x-1][y-1]!=0) {
					System.out.println(arr[x-1][y-1]);
					System.exit(0);
				}
			}
		}

		System.out.println(arr[x-1][y-1]);
	}
	
	private static void BFS(int num) {
		Queue<Info> q = new LinkedList<>();
		
		// 현재 전이할 바이러스 번호랑 같은거
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == num) {
					q.add(new Info(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n || arr[nx][ny]!=0) continue;

				arr[nx][ny] = num;
			}
		}
	}
	
	private static class Info {
		int x, y;
		
		public Info(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}