import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int n;
	static int[][] arr;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			
			int cnt = 1;
			int x = 0, y = 0, d = 0; 
			while (cnt<=n*n) {
				arr[x][y] = cnt++;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx<0 || nx>=n || ny<0 || ny>=n || arr[nx][ny] != 0) {  // 범위 밖이거나, 숫자가 있으면(0이 아니면)
					d = (d+1)%4;  // 방향바꿈 
					nx = x + dx[d];
					ny = y + dy[d];
				}
				x = nx;
				y = ny;
			}
			
			System.out.printf("#%d\n",t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");					
				}
				System.out.println();
			}
		}
	}
}
