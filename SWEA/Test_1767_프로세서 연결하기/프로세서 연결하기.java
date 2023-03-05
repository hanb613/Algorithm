import java.util.*;
import java.io.*;


public class Solution {
	private static int T, N, size, min;
	private static int arr[][];
	private static int dx[] = {-1, 1, 0, 0};
	private static int dy[] = {0, 0, -1, 1};
	private static pair core[];
	private static boolean chk[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N]; 
			core = new pair[12]; 
			chk = new boolean[12];
			
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			size = 0; 
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < N - 1; j++) {
					if(arr[i][j] == 1) {
						core[size++] = new pair(i, j);
					}
				}
			}
			
			for(int i = size; i >= 0; i--) {
				combination(0, 0, i);
				if(min < Integer.MAX_VALUE) break;
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void combination(int idx, int cnt, int R) {
		if(cnt == R) {
			dfs(0, 0);
			return;
		}
		
		for(int i = idx; i < size; i++) {
			chk[i] = true;
			combination(i + 1, cnt + 1, R);
			chk[i] = false;
		}
	}
	
	public static void dfs(int idx, int cnt) {
		if(idx == size) {
			min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
			return;
		}
		
		if(!chk[idx]) { // 부분 집합에 포함되는 애들만 다음 단계로 넘어갈 수 있다.
			dfs(idx + 1, cnt);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int x = core[idx].x, y = core[idx].y, tmp = 0;
			boolean success = false;
			
			while(true) {
				x += dx[i]; 
				y += dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 갔으면 성공
					success = true;
					break;
				}
				if(arr[x][y] != 0) break;
				arr[x][y] = 2;
				tmp++;
			}
			
			if(success) {
				dfs(idx + 1, cnt + tmp);
			}
			
			while(true) { // 원 상태로 돌려놓기
				x -= dx[i]; 
				y -= dy[i];
				if(x == core[idx].x && y == core[idx].y) break;
				arr[x][y] = 0;
			}
		}
	}
	
	private static class pair{
		int x, y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}