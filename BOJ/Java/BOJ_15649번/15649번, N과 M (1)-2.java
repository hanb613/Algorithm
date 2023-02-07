import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] num;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        num = new int[n];
        visit = new boolean[n];
        
	    Solution(0);
	}
    
    public static void Solution(int k) {
    	if(k==m) {
    		for(int i=0; i<m; i++) {
    			System.out.print(num[i]+" ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
        	if(!visit[i]) {
        		visit[i]=true;
        		num[k]=i+1;
        		Solution(k+1);
        		visit[i]=false;
        	}
    	}
    }
}