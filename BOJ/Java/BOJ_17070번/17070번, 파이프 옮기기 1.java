import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int n, result;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        arr[0][0] = arr[0][1]=2; // 초기에 놓인 파이프
        
        // 0 : 가로, 1 : 세로, 2 : 대각선
        solve(0, 1, 0);
        
        System.out.println(result);
    }
    
    private static void solve(int x, int y, int dir) {
    	if(x==n-1 && y==n-1) { // 파이프가 (n-1, n-1)에 놓였으면 결과+1
    		result++;
    		return;
    	}
    	
    	switch(dir) {
	    	case 0: // 방향이 가로? 이동할 수 있는 방향 2가지
	    		if(y+1<n && arr[x][y+1]==0) { // 가로 방향으로 놓았을 때, 빈칸 체크
	    			arr[x][y+1]=2; // 파이프 놓기
		    		solve(x, y+1, 0);
		    		arr[x][y+1]=0; // 다시 되돌리기
		    		
	    		}
	    		if(x+1<n && y+1<n) { // 대각선 방향으로 놓았을 때,
	    			if(arr[x+1][y]==0 && arr[x][y+1]==0 &&arr[x+1][y+1]==0) { // 」방향으로 빈칸 체크
		    			arr[x+1][y+1]=2;
			    		solve(x+1, y+1, 2);	    
			    		arr[x+1][y+1]=0;
	    			} 
	    		}
	    		break;
	    		
	    	case 1: // 방향이 세로 ? 이동할 수 있는 방향 2가지
	    		if(x+1<n && arr[x+1][y]==0) { // 세로 방향으로 놓았을 때, 빈칸 체크
	    			arr[x+1][y]=2;
		    		solve(x+1, y, 1);
		    		arr[x+1][y]=0;
		    		
	    		}
	    		if(x+1<n && y+1<n) {
	    			if(arr[x+1][y]==0 && arr[x][y+1]==0 &&arr[x+1][y+1]==0) {
		    			arr[x+1][y+1]=2;
			    		solve(x+1, y+1, 2);	    
			    		arr[x+1][y+1]=0;
	    			}   		
	    		}
	    		break;
	    		
	    	case 2: // 방향이 대각선? 이동할 수 있는 방향 3가지
	    		if(y+1<n && arr[x][y+1]==0) {
	    			arr[x][y+1]=2;
		    		solve(x, y+1, 0);
		    		arr[x][y+1]=0;
		    		
	    		}
	    		if(x+1<n && arr[x+1][y]==0) {
	    			arr[x+1][y]=2;
		    		solve(x+1, y, 1);	    
		    		arr[x+1][y]=0;
	    		}
	    		if(x+1<n && y+1<n) {
	    			if(arr[x+1][y]==0 && arr[x][y+1]==0 &&arr[x+1][y+1]==0) {
		    			arr[x+1][y+1]=2;
			    		solve(x+1, y+1, 2);	    
			    		arr[x+1][y+1]=0;
	    			}   		
	    		}
	    		break;
    	}
    }
}
