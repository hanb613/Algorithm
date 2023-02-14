import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h, result = Integer.MIN_VALUE;
    static int[][][] arr;
    static Queue<Pair> q;
    
    static int[] dx = {1, 0, -1, 0, 0, 0}; 
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        arr = new int[h][n][m];
        q = new LinkedList<Pair>();
        
        for(int k=0; k<h; k++) {
        	for(int i=0; i<n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<m; j++) {
            		arr[k][i][j] = Integer.parseInt(st.nextToken());
            	}
            }
        }
        
        for(int k=0; k<h; k++) {
        	for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
            		if(arr[k][i][j]==1) { // 익은 토마토 큐에 삽입
            	    	q.add(new Pair(k, i, j));
            		}
            	}
            }
        }
        
        BFS();
        
        for(int k=0; k<h; k++) {
        	for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
            		if(arr[k][i][j]==0) { // 익지 않은 토마토 있으면 -1 출력 후 종료
            			System.out.println(-1);
            			System.exit(0);
            		}
            		else { 
            			result = Math.max(result, arr[k][i][j]);
            		}
            	}
            }
        }
        
        System.out.println(result-1);
    }
    
    public static void BFS() {
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		
    		for(int i=0; i<6; i++) {
    			int nx = p.x + dx[i];
    			int ny = p.y + dy[i];
    			int nz = p.z + dz[i];
    				
				if(nx<0 || ny<0 || nz<0 || nx>=n || ny>=m || nz>=h) continue;
				
				if(arr[nz][nx][ny]==0) {
					q.add(new Pair(nz, nx, ny));
					arr[nz][nx][ny] = arr[p.z][p.x][p.y]+1; // 이전에 익은 토마토 기간 + 1
				}
    		}
    	}
    }
    
    public static class Pair{
    	int x, y, z;
    	public Pair(int z, int x, int y) {
    		this.z=z;
    		this.x=x;
    		this.y=y;
    	}
    }
}
