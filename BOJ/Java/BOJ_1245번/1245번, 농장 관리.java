import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result;
	static boolean chk;
	static int[][] arr;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0, 1, -1, 1, -1};
	static int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];		
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					chk = false;
					DFS(i, j);
					
					if(!chk) result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			
			// 현재 높이보다 더 높은 봉우리가 있는 경우 산봉우리가 될 수 없음
			if(arr[nx][ny]>arr[x][y]) chk = true;
			
			if(!visited[nx][ny] && arr[x][y]==arr[nx][ny]) { // 방문하지 X && 같은 높이라면
				DFS(nx, ny);
			}
		}
	}
}