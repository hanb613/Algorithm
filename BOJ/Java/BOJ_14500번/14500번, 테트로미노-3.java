
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, result;
	static int[][] arr;
	static boolean[][] visit;

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int[][] ex = {{0,0,0,1}, {0,1,1,1}, {0,1,1,2}, {0,1,1,2}};
	static int[][] ey = {{0,1,2,1}, {1,0,1,2}, {0,0,1,0}, {1,0,1,1}};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		visit[i][j]=true;
        		solve(i,j,1,arr[i][j]);
        		visit[i][j]=false;
        		
        		solve2(i, j);
        	}
        }
        
        System.out.println(result);
    }
    
    private static void solve(int x, int y, int cnt, int sum) {
    	if(cnt==4) {
    		result=Math.max(result, sum);
    		return;
    	}
    	
    	for(int d=0; d<4; d++) {
    		int nx = x+dx[d];
    		int ny = y+dy[d];
    		
    		if(nx<0 || ny<0 || nx>=n || ny>=m || visit[nx][ny]) continue;
    		
    		visit[nx][ny]=true;
    		solve(nx, ny, cnt+1, sum+arr[nx][ny]);
    		visit[nx][ny]=false;	
    	}
    }
    
    private static void solve2(int x, int y) {
    	
    	for(int i=0; i<4; i++) {
        	boolean flag=false;
        	int sum=0;
    		for(int d=0; d<4; d++) {
        		int nx = x+ex[i][d];
        		int ny = y+ey[i][d];
        		
        		if(nx<0 || ny<0 || nx>=n || ny>=m) {
        			flag=true; break;
        		}
        		sum+=arr[nx][ny];
        	}
    		
    		if(!flag) result=Math.max(result, sum);
    	}
    }
    
}

