import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long n, a, b, c, d, result;
	static boolean check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		
		long tmp = 0;
		if (b*c < d*a) {
			tmp = b;
			b = d;
			d = tmp;
			
			tmp = a;
			a = c;
			c = tmp;
		}
		
		result = Long.MAX_VALUE;
		
		for (int i = 0; i < c; i++) {
			long j = (long) Math.ceil((double)(n - i*a)/c); // c를 i개 만큼 삼
			
			if (j<0) j = 0;
			
			result = Math.min(result, i*b + j*d);
		}
		
		System.out.println(result);
	}

}