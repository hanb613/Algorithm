import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, r, g, b;
	static int arr[][];
	static int rgb[][];
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arr=new int[n][3];
        rgb=new int[n][3];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<3; j++) {
        		rgb[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        arr[0][0]=rgb[0][0];
        arr[0][1]=rgb[0][1];
        arr[0][2]=rgb[0][2];
        
        int tmp = Math.min(solve(n-1, 0), solve(n-1, 1));
        int tmp2 = Math.min(tmp, solve(n-1, 2));
        System.out.println(Math.min(tmp, tmp2));
    }
    
    private static int solve(int k, int color) {
    	if(k<0) return 0; 
    	
    	if(arr[k][color]!=0) return arr[k][color];
    	
    	if(color==0) {
    		arr[k][0] = Math.min(solve(k-1, 1), solve(k-1, 2))+rgb[k][0];
    	} else if(color==1) {
    		arr[k][1] = Math.min(solve(k-1, 0), solve(k-1, 2))+rgb[k][1];
    	} else if(color==2) {
    		arr[k][2] = Math.min(solve(k-1, 0), solve(k-1, 1))+rgb[k][2];
    	}
    	
    	return arr[k][color];
    }
}