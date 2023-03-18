import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] arr;
    static boolean[][] visit;
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		visit[i][j]=true;
        		dfs(i, j, 1, arr[i][j]);
        		visit[i][j]=false;
        		
        		combi(i, j, 0, arr[i][j], 0);
        	}
        }
        
        System.out.println(result);
    }
    
    // ㅜ모양 = ㅓ,ㅏ,ㅗ 가능
    // 인접한 4칸 중 3칸을 선택 => 조합
    private static void combi(int x, int y, int cnt, int sum, int start) {
    	if(cnt==3) {
    		result=Math.max(result, sum);
    		return;
    	}
    	
    	for(int d=start; d<4; d++) {
    		int nx=x+dx[d];
    		int ny=y+dy[d];
    		
    		if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    		
    		combi(x, y, cnt+1, sum+arr[nx][ny], d+1);
    	}
    }
    
    // ㅜ모양을 제외한 나머지 => 깊이가 4인 dfs 탐색
    private static void dfs(int x, int y, int cnt, int sum) {
    	if(cnt==4) {
    		result=Math.max(result, sum);
    		return;
    	}
    	
    	for(int d=0; d<4; d++) {
    		int nx=x+dx[d];
    		int ny=y+dy[d];
    		
    		if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    		if(visit[nx][ny]) continue;
    		
    		visit[nx][ny]=true;
    		dfs(nx, ny, cnt+1, sum+arr[nx][ny]);
    		visit[nx][ny]=false;
    	}
    }
}
