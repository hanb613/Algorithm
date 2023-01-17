import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, r, c, d, result = 1;
	static int[][] arr;

	static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(r, c, d);
		
		System.out.println(result);
	}
	
	public static void DFS(int x, int y, int dir) {
		arr[x][y] = 2; // 청소했다 !
		
		for(int i=0; i<4; i++) {
	        dir -= 1; //왼쪽 방향으로 돌면서 탐색
            if(dir == -1) dir = 3;
            
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			
			if(arr[nx][ny]==0){
				result++;
				DFS(nx, ny, dir);
				return; // 다시 돌아왔을 때 계산 X
			}
		}
		
		// 주변에 청소 할 곳 없음
		int back = (dir + 2) % 4; // 북 <-> 남 , 동 <->서
		int bx = x + dx[back];
		int by = y + dy[back];
        
		if(by>=0 && bx<n && bx>=0 && by<m && arr[bx][by] != 1) { // 범위 내인데, 벽 X
			DFS(bx, by, dir);
		}
	}
}