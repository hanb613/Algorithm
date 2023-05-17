import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, result, sum, maxHeight;
	static int[][] arr;
	static boolean[][] visit;
	
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
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}
		
		for(int h=0; h<=maxHeight; h++) {
			visit = new boolean[n][n];
			sum=0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j] && arr[i][j]>h) {
						sum++;
						solve(i, j, h);
					}
				}
			}
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
	}
	
	private static void solve(int x, int y, int height) {
		visit[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n || visit[nx][ny]) continue;
			if(arr[nx][ny]<=height) {
				visit[nx][ny]=true;
				continue;
			}
			
			visit[nx][ny]=true;
			solve(nx, ny, height);
		}
	}
}
