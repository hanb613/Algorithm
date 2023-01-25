import java.io.*;
import java.util.*;

public class Main {
	static int n, ret;
	static int[] t, p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		p = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Solution(0, 0);
		
		System.out.println(ret);
	}
	
	public static void Solution(int k, int sum) {
		if(k==n) {
			ret = Math.max(ret, sum);
			return;
		}
		
		if(k>n) return;
		
		Solution(k+t[k], sum+p[k]);
		Solution(k+1, sum);
	}
}
