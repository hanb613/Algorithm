import java.util.*;
import java.io.*;

/*
 * 운영 비용 = K * K + (K - 1) * (K - 1)
 * 이익 = (M * 집 수) - 운영비용
 * 손해를 보지 않고 많은 집에 서비스 제공
 * */

public class Main {
	
	static int tc, n, m, result;
	static int[][] arr;
	static boolean[][] visit;
	static Queue<Info> q;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			result=0;
			q = new LinkedList<Info>();
			arr = new int[n][n];
			visit = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					init();
					BFS(i, j);
				}
			}
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void BFS(int x, int y) {
		q.offer(new Info(x, y));
		visit[x][y]= true;
		int k=1, house=0;
		
		if(arr[x][y]==1) house++;
		if(house * m - calc(k) >= 0) {
			result = Math.max(result, house);
		}
		
		while(!q.isEmpty()) {
			int size=q.size();
			k++;
			
			for(int i=0; i<size; i++) {
				Info p = q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = p.x+dx[d];
					int ny = p.y+dy[d];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n || visit[nx][ny]) continue;
					
					if(arr[nx][ny]==1) house++;
					q.offer(new Info(nx, ny));
					visit[nx][ny]=true;
				}
			}
			
			if(house * m - calc(k) >= 0) {
				result = Math.max(result, house);
			}
		}
	}
	
	private static int calc(int K) {
		return K * K + (K - 1) * (K - 1);
	}
	
	private static void init() {
		q.clear();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visit[i][j] = false;
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
