import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, n, b, result;
	static int[] h;
	static boolean[] visit;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	tc = Integer.parseInt(br.readLine());

    	for(int T=1; T<=tc; T++) {
        	st=new StringTokenizer(br.readLine());
        	n=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	h = new int[n];
        	visit = new boolean[n];
        	result=Integer.MAX_VALUE;
        	
        	st=new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++) {
        		h[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	solve(0, 0);
        	
        	System.out.println(String.format("#%d %d", T, result));
    	}
    }
    
    private static void solve(int k, int sum) {
    	if(k==n) {
    		if(sum>=b) 
        		result=Math.min(result, sum-b);
    		return;
    	}
    	
    	solve(k+1, sum+h[k]);
    	solve(k+1, sum);
    }
}