import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, minL, result;
    static int[][] arr, tmpArr;
    
    static int[] dx = {1, 0, -1, 0}; // 하 좌 상 우
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        minL = Math.min(n, m);
        
        arr = new int[n][m];
        tmpArr = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int k=0; k<r; k++) {
        	copyArr(tmpArr, arr);
        	for(int i=0; i<minL/2; i++) { // 회전 해야되는 레이어
        		int x=i, y=i;
        		
        		int dir=0;
        		while(dir<4) { // '하 좌 상 우'순으로 움직이다가 범위 벗어나면 방향 바꾸기
        			int nx = x+dx[dir];
        			int ny = y+dy[dir];
        			
        			if(nx<n-i && ny<m-i && nx>=i && ny>=i) {
        				arr[nx][ny]=tmpArr[x][y];
        				x=nx; y=ny;
        			}
        			else dir++;
        		}
            }
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println();
        }
    }
    
    private static void copyArr(int[][] A, int[][] B) {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			A[i][j] = B[i][j];
    		}
    	}
    }
}