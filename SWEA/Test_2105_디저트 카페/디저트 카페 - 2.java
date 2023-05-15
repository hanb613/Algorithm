import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, n, result;
	static int startX, startY;
	static int[][] arr;
	static boolean[] visit;
	
	static int[] dx = {1, 1, -1, -1}; // 우하, 좌하, 좌상, 우상
	static int[] dy = {1, -1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result=0;
			for(int i=0; i<n-2; i++) {
				for(int j=1; j<n-1; j++) {
					visit = new boolean[101];
					
					startX = i; startY = j;
					solve(i, j, 0, 1);
				}
			}
			
			if(result==0) System.out.println(String.format("#%d %d", T, -1));
			else System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void solve(int x, int y, int prevNum, int move) {
//		if(move>3 && x==startX && y==startY) {
//            result = Math.max(result, move-1);
//            return;
//      }
		
		for(int i=prevNum; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(visit[arr[nx][ny]]) continue;
			
			if(move>=3 && nx==startX && ny==startY) { // 3번 이상 탐색했고, 다음 칸이 시작점이면 (대각선으로 움직인 사각형)
				result = Math.max(result, move); // 최대값 갱신
				return;
			}
			
			visit[arr[nx][ny]]=true;
			solve(nx, ny, i, move+1);
			visit[arr[nx][ny]]=false;
		}
	}
}
