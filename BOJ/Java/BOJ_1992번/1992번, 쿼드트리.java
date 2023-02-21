import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] arr;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	
    	n = Integer.parseInt(br.readLine());
    	arr = new char[n][n];
    	
    	String str;
    	for(int i=0; i<n; i++) {
    		str = br.readLine();
    		for(int j=0; j<n; j++) {
    			arr[i][j] = str.charAt(j);
    		}
    	}
    	
    	Solution(0, 0, n);
    	System.out.println(sb.toString());
    }
    
    
    private static void Solution(int x, int y, int size) {
    	
    	if(!check(x, y, size)) {
    		sb.append("(");
    		Solution(x, y, size/2);
    		Solution(x, y+size/2, size/2);
    		Solution(x+size/2, y, size/2);
    		Solution(x+size/2, y+size/2, size/2);
    	}
    	else {
    		if(arr[x][y]=='0') sb.append("0");
    		else sb.append("1");
    		return;
    	}
    	sb.append(")");
    	
    }
    
    private static boolean check(int x, int y, int size) {
    	
    	for(int i=x; i<x+size; i++) {
    		for(int j=y; j<y+size; j++) {
    			if(arr[x][y]!=arr[i][j]) return false;
    		}
    	}
    	
    	return true;
    }
}