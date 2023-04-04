import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, result, cheese;
	static int[][] arr;
	static boolean[][] visit;
	static ArrayList<Info> list;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		list=new ArrayList<Info>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());	
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					cheese++;
					list.add(new Info(i, j));
				}
				
			}
		}
		
		while(cheese!=0) {
			visit = new boolean[n][m];
			BFS();
			melting();
			result++;
		}
		
		System.out.println(result);
	}
	
	// 외부 공기 판별
	private static void BFS() {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(0, 0));
		arr[0][0]=-1;
		visit[0][0]=true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx=p.x+dx[d];
				int ny=p.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
				if(arr[nx][ny]==1 || visit[nx][ny]) continue;
				
				visit[nx][ny]=true;
				arr[nx][ny]=-1;
				q.offer(new Info(nx, ny));
				
			}
		}
	}
	
	// 치즈 녹기
	private static void melting() {
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			int cnt=0;
			
			for(int d=0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || arr[nx][ny]==0) continue;
				
				if(arr[nx][ny]==-1) cnt++; // 외부 공기라면 cnt++
			}
			
			if(cnt>=2) { // 2번 이상 외부공기와 접촉했다면 치즈 녹음
				arr[x][y]=0;
				cheese--;
				list.remove(i); i--;
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