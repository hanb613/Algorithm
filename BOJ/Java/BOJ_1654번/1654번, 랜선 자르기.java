import java.io.*;
import java.util.*;

public class Main {
    
	static int k, n;
	static long[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new long[k];
		
		for(int i=0; i<k ;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long start = 1, end = arr[k-1];
		long result=0;
		while(start<=end) {
			long mid = (start+end)/2;
			long sum=0;
			
			for(int i=0; i<k; i++) {
				sum+=arr[i]/mid;
			}
			if(sum>=n) {
				start=mid+1;
				result = Math.max(result, mid);
			} else {
				end=mid-1;
			}
		}
		
		System.out.println(result);
	}
}