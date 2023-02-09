import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long result=987654321;
	static int[] S, B;
	static boolean[] visit;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	n = Integer.parseInt(br.readLine());
        S = new int[n];
        B = new int[n];
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	S[i] = Integer.parseInt(st.nextToken());
        	B[i] = Integer.parseInt(st.nextToken());
        }
        
        Solution(0, 0, 1, 0);
        
        System.out.println(result);
    }
    
    private static void Solution(int k, int cnt, long mul, long sum) {
    	if(k==n) {
    		if(cnt>0) {
    			result = Math.min(result, Math.abs(mul-sum));
    		}
    		return;
    	}
		
    	Solution(k+1, cnt+1, mul*S[k], sum+B[k]);
    	Solution(k+1, cnt, mul, sum);
    }
}