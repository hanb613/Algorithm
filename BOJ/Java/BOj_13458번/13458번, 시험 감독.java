import java.io.*;
import java.util.*;

public class Main {
	static int n, b, c;
	static int[] a;
	static long result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			if(a[i]<=b) {
				result++; continue;
			}
			else {
				result++;
				a[i]-=b;
				
				if(a[i]%c==0) result+=(a[i]/c);
				else result+=(a[i]/c)+1;
			}
		}
		System.out.println(result);
	}
}