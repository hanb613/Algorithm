import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, result;
	static int[][] num;
	static char[][] arr;
	static boolean[][] visit;
	static Info start, end;
	static ArrayList<Info> water;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		num = new int[n][m];
		visit = new boolean[n][m];
		water = new ArrayList<Info>();
		
		String str="";
		for(int i=0; i<n; i++) {
			str=br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='S') start = new Info(i, j);
				else if(arr[i][j]=='D') end = new Info(i, j);
				else if(arr[i][j]=='*') water.add(new Info(i, j));
			}
		}

		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(start.x, start.y));
		while(true) {
			// 물 이동
			int size=water.size();
			for(int i=0; i<size; i++) {
				int x = water.get(i).x;
				int y = water.get(i).y;
			
				for(int d=0; d<4; d++) {
					int nx=x + dx[d];
					int ny=y + dy[d];
					
					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
					if(arr[nx][ny]=='D' || arr[nx][ny]=='X' || arr[nx][ny]=='*') continue;
					
					arr[nx][ny]='*';
					water.add(new Info(nx, ny));
				}
			}

			// 고슴도치 이동
			size=q.size();
	        for(int i=0; i<size; i++) {
				Info p = q.poll();
				
				if(p.x == end.x && p.y==end.y) {
	                System.out.println(num[end.x][end.y]);
	                System.exit(0);
	            }
				
				for(int d=0; d<4; d++) {
					int nx = p.x+dx[d];
					int ny = p.y+dy[d];
					
					if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
					if(arr[nx][ny]=='S'||  arr[nx][ny]=='X' || arr[nx][ny]=='*') continue;
					
					q.offer(new Info(nx, ny));
					num[nx][ny] = num[p.x][p.y]+1;
					arr[nx][ny]='S';
				
				}	
			}
	        if(q.size()==0) break;
		}
		System.out.println("KAKTUS");
	}
	
	private static class Info{
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
	