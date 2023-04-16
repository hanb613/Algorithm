import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[n];
    	int[] dp = new int[n];

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int result=0;
    	for(int i=0; i<n-1; i++) {
    		for(int j=i+1; j<n; j++) {
    			if(arr[i]<arr[j]) {
    				dp[j]=Math.max(dp[j], dp[i]+1);
    				result=Math.max(result, dp[j]);
    			}
    		}
    	}

    	System.out.println(result+1);
    }
}
 