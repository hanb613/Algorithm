import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, cnt, sum, result;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					visit[i][j]=true;
					cnt++; sum=1;
					Solution(i, j);
				}
			}
		}
		System.out.printf("%d\n%d", cnt, result);
	}
	
	public static void Solution(int x, int y) {
		if(result < sum) result = sum;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny >=m) continue;
			if(visit[nx][ny]|| arr[nx][ny]==0) continue;
			
			visit[nx][ny] = true;
			sum++;
			Solution(nx, ny);
		}
		
		return;
	}
}
