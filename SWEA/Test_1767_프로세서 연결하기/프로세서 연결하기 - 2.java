import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, n, result, maxCore;
	static int[][] arr;
	static List<Info> core;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			core = new ArrayList<Info>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					if(arr[i][j] == 1) {
						if(i!=0 && i!=n-1 && j!=0 && j!=n-1) { // 가장자리에 있는 core 제외
							core.add(new Info(i, j));
						}
					}
				}
			}
			
			maxCore = 0;
			result = Integer.MAX_VALUE;
			
			solve(0, 0, 0);
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void solve(int k, int coreCnt, int sum) {
		if(k==core.size()) {
			// 최대한 많은 코어 연결
			// 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				result = sum;
			} else if(maxCore == coreCnt){ // 전선 길이의 합 -> 최소값으로 갱신
				result = Math.min(result, sum);
			}
			return;
		}
		
		Info p = core.get(k);
		for(int i=0; i<4; i++) { // 상하좌우 탐색
			
			int nx = p.x, ny = p.y;
			int length=0;
			
			// 전선 연결 할 수 있는지, 없는지 판단
			while(true) {
				nx += dx[i];
				ny += dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) break; // 가장 자리에 연결 됐을 때
				if(arr[nx][ny]==1) { // 다른 전선이나 코어를 만났을 때
					length=0; 
					break;
				} 
				
				length++;
			}
			
			if(length==0) { // 연결 X
				solve(k+1, coreCnt, sum);
			} else { // 연결 O
				// 전선 연결
				nx = p.x; ny = p.y;
				for(int j=0; j<length; j++) {
					nx += dx[i];
					ny += dy[i];
					arr[nx][ny]=1;
				}
				
				solve(k+1, coreCnt+1, sum+length);

				// 다시 되돌리기
				nx = p.x; ny = p.y;
				for(int j=0; j<length; j++) {
					nx += dx[i];
					ny += dy[i];
					arr[nx][ny]=0;
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