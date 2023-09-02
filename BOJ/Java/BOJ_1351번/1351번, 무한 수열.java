import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static long n, p, q;
	static Map<Long, Long> map;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new HashMap<>();
				
		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		
		System.out.println(solve(n));
    }
	
	private static long solve(long n) {
		if(n==0) return 1;
		if(map.containsKey(n)) return map.get(n);
		
		long a = (long)Math.floor(n/p);
		long b = (long)Math.floor(n/q);
		
		map.put(n, solve(a)+solve(b));
		
		return map.get(n);
	}
}