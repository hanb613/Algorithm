import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static long a,b,c, result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a=Long.parseLong(st.nextToken());
        b=Long.parseLong(st.nextToken());
        c=Long.parseLong(st.nextToken());
       
        System.out.println(solve(a, b) % c);
    }
    
    private static long solve(long a, long n) {
    	if(n == 1) {
			return a % c;
		}
    	
		long temp = solve(a, n/2);
		
		if(n % 2 == 1) {
			return (temp*temp % c)*a%c;
		}
		return temp*temp % c;
    }
}