import java.io.*;
import java.util.*;

public class Solution{
	
	static int n, result;
	static char[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int T=1 ; T<=tc ; T++) {
			n=Integer.parseInt(br.readLine());
			
			arr= new char[n][n];
			visit = new boolean[n][n];
			
			String str;
			for(int i=0; i<n; i++) {
				str = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j]=str.charAt(j);
					if(arr[i][j]=='*') visit[i][j]=true;

				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int cnt=0;
					for(int k=0; k<8; k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						if(arr[nx][ny]=='*') cnt+=1; 
					}		
					
					if(arr[i][j]=='.') arr[i][j]=(char)(cnt+'0');
				}
			}
			
			result=0;
			//0 이 뭉쳐있는것들 방문처리, 0옆에 붙어있는거 방문처리
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j] && arr[i][j]=='0') {
						bfs(i, j);
						result+=1;
					}
				}
			}
			
			// 나머지 방문 안된것들만 더하기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j]) {
						result+=1;
					}
				}
			}
			
			System.out.println("#"+T+" "+result);
		}

	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.offer(new Pair(x, y));
		visit[x][y]=true;
		
		while(!q.isEmpty()) {
			Pair p=q.poll();
			
			for(int k=0; k<8 ; k++) {
				int nx=p.x+dx[k];
				int ny=p.y+dy[k];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(visit[nx][ny]) continue;
				
				if(arr[nx][ny]=='0') {
					visit[nx][ny]=true;
					q.offer(new Pair(nx, ny));
				}
				
				else if(arr[nx][ny]!='0') {
					visit[nx][ny]=true;
				}
			}
		}
	}
	
	private static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}