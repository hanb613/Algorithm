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
    static int[][] dir = {{-1,0,1,0}, {0,-1,0,1}};
    
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
    		
    		time=0;
    		result=1;
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
    		int nx, ny;
    	
    		switch(arr[p.r][p.c]) {
    			case 1:
    				for(int d=0; d<4; d++) {
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					if(p.time==l) break;
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
				
    			case 2:
    				for(int d=0; d<4; d++) {
    					if(d==1 || d==3) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					if(p.time==l) break;
    					
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    			case 3:
    				for(int d=0; d<4; d++) {
    					if(d==0 || d==2) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					if(p.time==l) break;
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    			case 4:
    				for(int d=0; d<4; d++) {
    					if(d==1 || d==2) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					if(p.time==l) break;
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    			case 5:
    				for(int d=0; d<4; d++) {
    					if(d==0 || d==1) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					if(p.time==l) break;
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    			case 6:
    				for(int d=0; d<4; d++) {
    					if(d==0 || d==3) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					if(p.time==l) break;
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    			case 7:
    				for(int d=0; d<4; d++) {
    					if(d==2 || d==3) continue;
    					nx = p.r + dir[0][d];
    					ny = p.c + dir[1][d];
    					if(p.time==l) break;
    					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    					if(visit[nx][ny] || arr[nx][ny]==0) continue;
    					
    					if(check(d, nx, ny)) {
        					q.offer(new Pair(nx, ny, p.time+1));
        					visit[nx][ny]=true;
        					result++;
    					}
    				}
    				break;
    		}	
    	}
    }
    
    private static boolean check(int d, int nx, int ny) {
    	if(d==0 && (arr[nx][ny]==1 || arr[nx][ny]==2||arr[nx][ny]==5||arr[nx][ny]==6)) {
			return true;   						
		} else if(d==1 && (arr[nx][ny]==1 || arr[nx][ny]==3 || arr[nx][ny]==4 || arr[nx][ny]==5)) {
			return true;   		
		} else if(d==2 && (arr[nx][ny]==1 || arr[nx][ny]==2 || arr[nx][ny]==4 || arr[nx][ny]==7)) {
			return true;   		 
		} else if(d==3 && (arr[nx][ny]==1 || arr[nx][ny]==3 || arr[nx][ny]==6 || arr[nx][ny]==7)) {
			return true;   
		}
    	
    	return false;
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