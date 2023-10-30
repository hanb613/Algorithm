import java.util.*;
import java.io.*;

public class Main {

	static int n, k;
	static int s, x, y;
	static int[][] arr;
	static PriorityQueue<Info> pq;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j]!=0) {
					pq.add(new Info(i, j, arr[i][j]));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		// s초동안 바이러스 전파
		for(int i=0; i<s; i++) {
			BFS();
		}

		System.out.println(arr[x-1][y-1]);
	}
	
	private static void BFS() {
		Queue<Info> q = new LinkedList<>();
		
		// 현재 pq에 있는 바이러스 정보 q로 옮기기
		while(!pq.isEmpty()) {
			Info iq = pq.poll();
			q.add(new Info(iq.x, iq.y, iq.num));
		}
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n || arr[nx][ny]!=0) continue;

				arr[nx][ny] = p.num;
				pq.add(new Info(nx, ny, p.num));
			}
		}
	}
	
	private static class Info implements Comparable<Info> {
		int x, y, num;
		
		public Info(int x, int y, int num) {
			this.x=x;
			this.y=y;
			this.num=num;
		}

		@Override
		public int compareTo(Info o) {
			return this.num-o.num;
		}
		
	}
}