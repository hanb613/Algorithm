import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int tc, n, m, cnt, roomNum, result;
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int T=1; T<=tc; T++) {
			result = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt=1;
					visit = new boolean[n][n];
					Solution(i,j);
					if(result<cnt) {
						result = cnt;
						roomNum = arr[i][j];
					}
					if(result == cnt) { // 방 번호 작은 걸로 
						roomNum = Math.min(arr[i][j], roomNum);
					}
					result = Math.max(result, cnt);
				}
			}
			
			System.out.println(String.format("#%d %d %d", T, roomNum, result));
		}
	}
	private static void Solution(int x, int y) {
		visit[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n || visit[nx][ny]) continue;
			if(arr[nx][ny] == arr[x][y]+1) {
				visit[nx][ny]=true;
				cnt++;
				Solution(nx, ny);
			}
		}
	}
}