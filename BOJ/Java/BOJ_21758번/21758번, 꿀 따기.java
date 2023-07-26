import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long result, sumA, sumB;
	static int[] arr;
	static long[] sumArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		sumArr = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumArr[i]=arr[i]+sumArr[i-1];
		}
		
		// 벌 벌통 벌
		for(int i=2; i<n; i++) {
			sumA = sumArr[i]-arr[1];
			sumB = sumArr[n]-sumArr[i-1]-arr[n];
			result = Math.max(result, sumA+sumB);
		}
		
		// 벌통 벌 벌
		for(int i=2; i<n; i++) {
			sumA = sumArr[n]-arr[n]-arr[i];
			sumB = sumArr[i-1];
			result = Math.max(result, sumA+sumB);
		}
		
		// 벌 벌 벌통
		for(int i=2; i<n; i++) {
			sumA = sumArr[n]-arr[1]-arr[i];
			sumB = sumArr[n]-sumArr[i];
			result = Math.max(result, sumA+sumB);
		}

		System.out.println(result);
	}

}