import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t, result;
    static int topX, bottomX;
    
    static int[][] arr, tmpArr;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        tmpArr = new int[r][c];
        
        for(int i=0; i<r; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<c; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(bottomX==0 && arr[i][j] == -1) {
        			topX = i; bottomX=i+1;
        		}
        	}
        }

        for(int i=0; i<t; i++) {
            copyArr(tmpArr, arr);
            dust();
            move();
        }
        
        for(int i=0; i<r; i++) {
    		for(int j=0; j<c; j++) {
    			if((i==topX && j==0) || (i==bottomX && j==0)) continue;
    			result += arr[i][j];
    		}
    	}
        
        System.out.println(result);
    }
    
    private static void copyArr(int[][] A, int[][] B) {
    	for(int i=0; i<r; i++) {
    		for(int j=0; j<c; j++) {
    			A[i][j] = B[i][j];
    		}
    	}
    }
    
    private static void dust() {
    	for(int i=0; i<r; i++) {
    		for(int j=0; j<c; j++) {
    			if(arr[i][j] != -1 && arr[i][j]!=0) {
    				int cnt=0;
        			for(int d=0; d<4; d++) {
        				int nx = i+dx[d];
        				int ny = j+dy[d];
        				
        				if(nx<0 || ny<0 || nx>=r || ny>=c || tmpArr[nx][ny]==-1) continue;
        				arr[nx][ny]+=tmpArr[i][j]/5;	
        				cnt++;
        			}
        			arr[i][j] = arr[i][j] - (tmpArr[i][j]/5)*cnt;
    			}
    		}
    	}
    }
    
    private static void move() {
    	
    	for (int i=topX-1; i>0; i--) {
            arr[i][0] = arr[i-1][0];    		
    	}

        for (int i=0; i<c-1; i++) {
            arr[0][i] = arr[0][i+1];
        }

        for (int i=0; i<topX; i++) {
            arr[i][c-1] = arr[i+1][c-1];
        }

        for (int i=c-1; i>1; i--) {
            arr[topX][i] = arr[topX][i-1];
        }
        arr[topX][1] = 0;
    	
        for (int i=bottomX+1; i<r-1; i++) {
            arr[i][0] = arr[i+1][0];        	
        }

        for (int i=0; i<c-1; i++) {
        	arr[r-1][i] = arr[r - 1][i + 1]; 
        }

        for (int i=r-1; i>bottomX; i--) {
        	arr[i][c-1] = arr[i-1][c-1];
        }

        for (int i=c-1; i>1; i--) {
        	arr[bottomX][i] = arr[bottomX][i-1];
        }
        arr[bottomX][1] = 0;
    	
    }
}