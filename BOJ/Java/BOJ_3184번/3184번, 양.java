import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, sheep, wolf;
	static int inpWolf, inpSheep;
	static char[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		visit = new boolean[r][c];
		
		String str="";
		for(int i=0; i<r; i++) {
			str = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='v') inpWolf++;
				else if(arr[i][j]=='o') inpSheep++;
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j]=='o') {
					sheep=1; wolf=0;
					visit[i][j]=true;
					solve(i, j);
					if(sheep>wolf) inpWolf-=wolf;
					else inpSheep-=sheep;
				}
			}
		}
		
		System.out.println(inpSheep + " "+ inpWolf);
	}
	
	private static void solve(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
			if(visit[nx][ny] || arr[nx][ny]=='#') continue;
			
			visit[nx][ny]=true;
			if(arr[nx][ny]=='v') wolf++;
			else if(arr[nx][ny]=='o') sheep++;
			solve(nx, ny);
		}
	}
}
