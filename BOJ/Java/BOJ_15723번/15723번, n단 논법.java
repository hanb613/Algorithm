import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	static int n, m;
	static boolean[][] arr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	arr = new boolean[26][26];
    	
    	int a,b;
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = st.nextToken().charAt(0)-'a';
    		st.nextToken();
    		b = st.nextToken().charAt(0)-'a';

    		arr[a][b]=true;
    	}
    	
    	// 플로이드 와샬
    	for(int k=0; k<26; k++) {
    		for(int i=0; i<26; i++) {
        		for(int j=0; j<26; j++) {
        			if(arr[i][k] && arr[k][j]) {
        				arr[i][j]=true;
        			}
        		}
        	}
    	}
    	
    	m = Integer.parseInt(br.readLine());
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = st.nextToken().charAt(0)-'a';
    		st.nextToken();
    		b = st.nextToken().charAt(0)-'a';
    		
    		if(arr[a][b]) System.out.println("T");
    		else System.out.println("F");
    	}
    }
}
 