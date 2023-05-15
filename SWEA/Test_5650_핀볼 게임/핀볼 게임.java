import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
	
	static int tc, n, result;
	static List<Hole> wormHole;
	static int[][] arr;
	
	static int[] dx = {-1, 0, 1, 0}; // 상 좌 하 우
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] dir = {
			{},
			{3, -1, -1, 0}, // 1번 : 우 반대방향 반대방향 상
			{-1, -1, 3, 2}, // 2번 : 반대 반대 우 하
			{-1, 2, 1, -1}, // 3번 : 반대 하 좌 반대
			{1, 0, -1, -1}, // 4번 : 좌 상 반대 반대
			{-1, -1, -1, -1}, // 5번 : 반대 반대 반대 반대
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine().trim());
		for(int T=1; T<=tc; T++) {
			n = Integer.parseInt(br.readLine().trim());
			
			arr = new int[n+2][n+2];
			wormHole = new ArrayList<Hole>();
			result = 0;
			
			for(int i=0; i<n+2; i++) {
				if(i==0 || i==n+1) { // 가장자리 -> 항상 반대방향 : 5
					for(int j=0; j<n+2; j++) {
						arr[i][j]=5;
					}
				} else {
					arr[i][0] = arr[i][n+1] = 5; // 가장자리 -> 항상 반대방향 : 5
					st = new StringTokenizer(br.readLine(), " ");
					for(int j=1; j<n+1; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
						if(arr[i][j]>5) wormHole.add(new Hole(i, j, arr[i][j]));
					}					
				}
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][j]==0) {
						arr[i][j] = -1; // 시작자리 -> 블랙홀 처럼 -1로
						for(int k=0; k<4; k++) {
							Simulation(i, j, k);
						}
						arr[i][j] = 0; // 다시 되돌려놓기
					}
				}
			}
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void Simulation(int x, int y, int d) {

		int nx = x, ny = y, nd = d;
		int score=0;
		
		while(true) {
			
			nx += dx[nd];
			ny += dy[nd];
			
			if(arr[nx][ny]==0) continue; // 빈공간
			else if(arr[nx][ny] == -1) { // 시작점 || 블랙홀이면 ? 
				result = Math.max(result, score);
				return;
			}			
			else if(arr[nx][ny]>=1 && arr[nx][ny]<=5) { // 벽 || 블록이면 ?
				score++;
				nd = (nd+2)%4; // 반대 방향
				if(dir[arr[nx][ny]][nd]!=-1) { // 다시 방향을 바꿔야되는 벽 || 블록을 마주했을 때
					nd = dir[arr[nx][ny]][nd];
				}
			} else if(arr[nx][ny]>=6) { // 웜홀이면 ?
				loop : for(int i=0; i<wormHole.size(); i++) {
					Hole nh = wormHole.get(i);
					if(nh.num==arr[nx][ny]) { // 같은 웜홀 번호이고
						if(nh.x!=nx || nh.y!=ny) { // 반대편 웜홈이면 (x, y 중 하나라도 다르면 OK)
							nx = nh.x; ny = nh.y;
							break loop;
						}
					}
				}
			}
		}
	}

	private static class Hole{
		int x, y, num;

		public Hole(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}

/*
 *  1
	3
	6 -1 6
	7 0 7
	8 -1 8
	=> 0
	
	1
	5
	0 6 7 6 7
	5 5 5 5 5
	5 5 5 5 5
	5 5 5 5 5
	5 5 5 5 5
	=> 1
 * */