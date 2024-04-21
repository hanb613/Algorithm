import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k, cnt, result;
	static int[][] arr;
	static boolean[][] visited;
	static PriorityQueue<Info> pq;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(i==0 || j==0 || i==n-1 || j==m-1) { // 가장자리에 있는 옥수수면 pq에 넣기
					pq.offer(new Info(arr[i][j], i, j));
					visited[i][j] = true;
				}
			}
		}
		
		k = Integer.parseInt(br.readLine());

		BFS();
	
		System.out.println(sb.toString());
	}
	
	private static void BFS() {
		
		while(!pq.isEmpty()) {
			Info p = pq.poll(); // 현재 가치가 제일 높은 옥수수
			cnt++;
			sb.append(p.x+1).append(" ").append(p.y+1).append("\n");
			
			if(cnt==k) return; // k개 수확했으면 return
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				pq.offer(new Info(arr[nx][ny], nx, ny));
			}
		}
	}
	
	private static class Info implements Comparable<Info> {
		int num, x, y;
		
		public Info(int num, int x, int y) {
			this.num=num;
			this.x=x;
			this.y=y;
		}
		
		@Override
		public int compareTo(Info o) {
			return o.num - this.num;
		}
	}
}