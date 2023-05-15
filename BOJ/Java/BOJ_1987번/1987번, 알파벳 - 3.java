import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, result;
	static char[][] arr;
	static boolean[] visit;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		visit = new boolean[26];
		
		String str = "";
		for(int i=0; i<r; i++) {
			str = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		visit[arr[0][0]-'A'] = true;
		solve(0, 0, 1);
		
		System.out.println(result);
	}
	
	private static void solve(int x, int y, int length) {
		result = Math.max(result, length);
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=r || ny>=c || visit[arr[nx][ny]-'A']) continue;
			
			visit[arr[nx][ny]-'A'] = true;
			solve(nx, ny, length+1);	
			visit[arr[nx][ny]-'A'] = false;
		}
	}
}
