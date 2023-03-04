import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int tc, n, m ,r, c, l, result, time;
    static int[][] arr;
    static boolean[][] visit;
	static int[][] dx = {{0,0,0,0}, {-1,1,0,0}, {-1,1,0,0}, {0,0,0,0}, {-1,0,0,0}, {0,1,0,0}, {0,1,0,0}, {-1,0,0,0}}; //1번 - 7번
	static int[][] dy = {{0,0,0,0}, {0,0,-1,1}, {0,0,0,0}, {0,0,-1,1}, {0,0,0,1}, {0,0,0,1}, {0,0,-1,0}, {0,0,-1,0}};
	static int[][] dir = {{1,2,5,6}, {1,2,4,7}, {1,3,4,5}, {1,3,6,7}}; // 상하좌우 -> 갈 수 있는 파이프 번호
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	tc = Integer.parseInt(br.readLine());
    	for(int T=1; T<=tc; T++) {
    		st = new StringTokenizer(br.readLine());
    		n=Integer.parseInt(st.nextToken());
    		m=Integer.parseInt(st.nextToken());
    		r=Integer.parseInt(st.nextToken());
    		c=Integer.parseInt(st.nextToken());
    		l=Integer.parseInt(st.nextToken());
    		
    		arr = new int[n][m];
    		visit = new boolean[n][m];
    		
    		for(int i=0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<m; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		time=0; result=1;
    		BFS(r, c);
    		
    		System.out.println(String.format("#%d %d", T, result));
    	}
    }
    
    private static void BFS(int x, int y) {
    	Queue<Pair> q = new LinkedList<Pair>();
    	q.offer(new Pair(x, y, 1));
    	visit[x][y]=true;
    	
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		if(p.time==l) return;
    		
    		for(int i=1; i<8; i++) { // 1 ~ 7번
				if(arr[p.r][p.c] == i) {
					for(int j=0; j<4; j++) { //상하좌우
						int nx = p.r+dx[i][j];
						int ny = p.c+dy[i][j]; 
						
						if(nx<0 || ny<0 || nx>=n || ny>=m) continue; // 범위 넘어가면 X
						if(arr[nx][ny] == 0 || visit[nx][ny]) continue; // 0이거나 방문했던 곳이면 X
							
						
						for(int k=0; k<4; k++) { // 4방위 탐색
							if(dir[j][k] == arr[nx][ny]){ // 갈 수 있는 곳이면  GO
								visit[nx][ny] = true;
								result++;
								q.add(new Pair(nx,ny, p.time+1));
							}
						}
					}
				}
			}
    	}
    }
    
    private static class Pair{
    	int r, c, time;
		public Pair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time=time;
		}
    }
}