import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
	static int tc, n, k;
	static long c1, c2;
    static long[] factorial;

	static final int MOD = 1234567891;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
       
        tc = Integer.parseInt(br.readLine());
        
        for(int T=1; T<=tc; T++){
        	st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            factorial = new long[n+1];
            
            // n팩토리얼까지 값 구하기
            factorial[0] = 1;
            for(int i=1; i<=n; i++){
                factorial[i] = factorial[i-1] * i % MOD;
            }

            c1 = (factorial[n-k] * factorial[k]) % MOD;
            c2 = pow(c1, MOD-2);

            sb.append("#").append(T).append(" ").append(factorial[n] * c2 % MOD).append("\n");
        }
        System.out.println(sb);
    }
	
    private static long pow(long n, long k) {
        if(k == 0) return 1; // 지수가 0이면 1리턴
        else if(k == 1) return n; // 지수가 1이면 밑 리턴
        
        long x = pow(n, k/2);
        long ret = (x * x) % MOD;
        
        if(k % 2 == 0) return ret; // k가 짝수면 x제곱 
        else return (ret * n) % MOD; // k가 홀수면 x제곱 * 밑
        
    }
}