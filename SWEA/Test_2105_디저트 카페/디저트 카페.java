import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int tc, n, result;
    static int start, end;
    static int[][] arr;
    static boolean[][] visit;
    static boolean[] dessert;
    
    static int[] dx= {1, 1, -1, -1}; // 우하, 좌하, 좌상, 우상
    static int[] dy= {1, -1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	tc = Integer.parseInt(br.readLine());
    	for(int T=1; T<=tc; T++) {
    		st = new StringTokenizer(br.readLine());
    		n=Integer.parseInt(st.nextToken());
    		
    		result=0;
    		arr = new int[n][n];
    		
    		for(int i=0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<n; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}

    		for(int i=0; i<n-2; i++) {
    			for(int j=1; j<n-1; j++) {
    				start=i; end=j; // 시작점의 x y 좌표 저장
    				visit = new boolean[n][n];
    	    		dessert = new boolean[101];
    	    		Solve(i, j, 0, 1);
    			}
    		}
    		
    		if(result==0) {
        		System.out.println(String.format("#%d %d", T, -1));
    		} else {
    			System.out.println(String.format("#%d %d", T, result));
    		}
    	}
    }
    
    // 이전 방향이랑 같거나, 다음 방향으로 이동할 수 있도록  (ex. 좌하 -> 우하 X)
    private static void Solve(int x, int y, int prevDir, int cnt) {
    	if(cnt>3 && x==start && y==end) { // 최소 3번은 탐색했고, 시작점으로 돌아왔으면
			result=Math.max(result, cnt-1);
			return;
		}
    	
    	for(int i=prevDir; i<4; i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		
    		if(nx<0 || ny<0 || nx>=n || ny>=n) continue; // 범위 벗어나면 X
    		if(visit[nx][ny] || dessert[arr[nx][ny]]) continue; // 방문했거나, 해당 디저트를 먹었으면 X
    		
    		visit[nx][ny]=true; // 해당 좌표 방문 했다 !
    		dessert[arr[nx][ny]]=true; // 해당 디저트 종류는 먹었다 ! 
    		Solve(nx, ny, i, cnt+1);
    		visit[nx][ny]=false; // 되돌리기
    		dessert[arr[nx][ny]]=false; // 되돌리기2
    	}
    }
}