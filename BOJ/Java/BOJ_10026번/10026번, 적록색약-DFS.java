import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, resultA, resultB;
    static char[][] arr;
    static boolean[][] visitA, visitB;
    static int[] dx = {-1, 0, 1, 0}; // 상 하 좌 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new char[n][n];
        visitA = new boolean[n][n];
        visitB = new boolean[n][n];
        
        String str;
        for(int i=0; i<n; i++) {
            str=br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(!visitA[i][j]) {
        			DFS(0, i, j);
        			resultA++;
        		}
        		
        		if(!visitB[i][j]) {
        			DFS(1, i, j);
        			resultB++;
        		}
        	}	
        }
        System.out.println(resultA + " "+resultB);
    }
    
    private static void DFS(int type, int x, int y) {
    	
    	for(int d=0; d<4; d++) {
    		int nx = x+dx[d];
    		int ny = y+dy[d];
    		
    		if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
    		
    		if(type==1) {
    			char tmp = arr[nx][ny];
    			if(arr[x][y]=='G' && arr[nx][ny]=='R') tmp='G';
    			else if(arr[x][y] =='R' && arr[nx][ny]=='G') tmp='R';
    			
    			if(!visitB[nx][ny] && arr[x][y] == tmp) {
    				visitB[nx][ny]=true;
    				DFS(type, nx, ny);
    			}
    		}
    		else {
        		if(!visitA[nx][ny] && arr[x][y]==arr[nx][ny]) {
        			visitA[nx][ny]=true;
        			DFS(type, nx, ny);
        		}
    		}
    	}
        return;
    }
}