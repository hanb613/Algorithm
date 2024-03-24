import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k, result;
	static int[] arr, diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		diff = new int[n-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i=0; i<n-1; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(diff);
		
		for(int i=0; i<n-k; i++) {
			result+=diff[i];
		}
		
		System.out.println(result);
	}
	
}