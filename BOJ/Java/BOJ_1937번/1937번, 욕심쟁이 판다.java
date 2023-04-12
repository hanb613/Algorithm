import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	static int n, m, result;
	static int[][] arr, dp;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n][n];
    	dp = new int[n][n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			result = Math.max(result, solve(i, j));
    		}
    	}
    	System.out.println(result);
    }
    
    private static int solve(int x, int y) {
    	// 이미 계산된 지역이면 바로 리턴
		if(dp[x][y]!=0) return dp[x][y];
		
		dp[x][y] = 1;
    	for(int d=0; d<4; d++) {
    		int nx = x+dx[d];
    		int ny = y+dy[d];
    		
    		// 범위가 벗어나고, 이동한 칸의 값이 현재 칸 값보다 작거나 같으면 X
    		if(nx<0 || ny<0 || nx>=n || ny>=n || arr[x][y]>=arr[nx][ny]) continue;
    		
    		// 현재 저장된 값과 새로 탐색한 값 비교
    		dp[x][y] = Math.max(dp[x][y], solve(nx, ny)+1);
    	}
    	
    	return dp[x][y];
    }
}
 