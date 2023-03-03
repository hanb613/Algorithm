import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int tc, n, resultA, resultB;
    static int[] arr, oper, tmp;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= tc; T++) {

        	n = Integer.parseInt(br.readLine());
        	
        	resultA=Integer.MIN_VALUE;
        	resultB = Integer.MAX_VALUE;
        	
        	oper = new int[4];
        	arr = new int[n];
        	tmp = new int[n];
        	
        	st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) {
            	oper[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Solve(0, 0);
            System.out.println(String.format("#%d %d", T, resultA-resultB));
        }
    }
    
    private static void Solve(int k, int cnt) {
    	
    	if(cnt==n-1) {
    		int ret=arr[0];
    		for(int i=0; i<n-1; i++) {
    			if(tmp[i]==0) {
    				ret+=arr[i+1];
    			} else if(tmp[i]==1) {
    				ret-=arr[i+1];
    			} else if(tmp[i]==2) {
    				ret*=arr[i+1];
    			} else {
    				ret/=arr[i+1];
    			}
    		}
    		resultA = Math.max(resultA, ret);
    		resultB = Math.min(resultB, ret);
    		return;
    	}
    	
    	for(int i=0; i<4; i++) {
    		if(oper[i]>0) {
    			tmp[k]=i;
    			oper[i]--;
    			Solve(k+1, cnt+1);
       			oper[i]++;
    		}
    	}
    }
}