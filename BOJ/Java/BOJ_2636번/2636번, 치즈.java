import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// result : 모두 녹아서 없어지는 데 걸리는 시간
	// result2 : 녹기 한 시간 전에 남아 있는 치즈 개수
	// cheese : 처음에 있는 치즈의 개수 
	static int n, m, result, result2, cheese;
	static int[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					cheese++;
				}
			}
		}
		
		while(cheese!=0) { // 치즈가 모두 없어질 때 까지
			result++;
			result2=cheese;
			BFS();			
		}
		
		System.out.println(result);
		System.out.println(result2);
	}
	
	private static void BFS() {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(0, 0));
		visit = new boolean[n][m];
		visit[0][0]=true;
		
		Info p;
		while(!q.isEmpty()) {
			p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || visit[nx][ny]) continue;
				
				visit[nx][ny]=true;
				if(arr[nx][ny]==1) { // 인접한 칸이 치즈라면, 0으로 바꾼 후 개수 감소
					cheese--;
					arr[nx][ny]=0;
				} else if(arr[nx][ny]==0) { // 빈칸이면 큐에 넣기
					q.add(new Info(nx, ny));
				}
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
