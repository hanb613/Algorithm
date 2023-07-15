import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[] arr;
    static int[][][] dp;
    static final int INF = 987654321;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        arr = new int[3];
        dp = new int [61][61][61];

        n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        result = Solution(arr[0], arr[1], arr[2]);
        
        System.out.println(result);

    }

    private static int Solution(int a, int b, int c) {
    	
    	if (a<0) return Solution(0, b, c);
    	if (b<0) return Solution(a, 0, c);
    	if (c<0) return Solution(a, b, 0);

    	if (a==0 && b==0 && c==0) return 0;

    	if (dp[a][b][c] != 0) return dp[a][b][c];

    	dp[a][b][c] = INF;
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-9, b-3, c-1)+1);
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-9, b-1, c-3)+1);
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-1, b-3, c-9)+1);
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-1, b-9, c-3)+1);
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-3, b-1, c-9)+1);
    	dp[a][b][c] = Math.min(dp[a][b][c], Solution(a-3, b-9, c-1)+1);

    	return dp[a][b][c];

	}
}