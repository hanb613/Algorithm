import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long minVal, resultA, resultB;
	static long[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
				
		minVal = 2_000_000_000; 
		int left=0, right=n-1;
		
		while(left<right) {
			long sum = arr[left] + arr[right];
			
			if(Math.abs(sum)<=minVal) {
				minVal = Math.abs(sum);
				resultA = arr[left];
				resultB = arr[right];
			} 
			
			if(sum>=0) right--;
			else left++;
		}
		
		System.out.println(resultA + " " + resultB);
	}

}