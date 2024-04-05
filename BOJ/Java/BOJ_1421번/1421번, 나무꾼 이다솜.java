import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, c, w;
	static long result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=1; i<=arr[n-1]; i++) {
			long total = 0; // 총 비용
			
			for(int j=0; j<n; j++) {
				int cut = 0; // 자른 나무 개수
				int div = arr[j]/i;
				
				if(arr[j]>=i) { // 현재 나무 길이가, 탐색중인 길이보다 클 때
					if(arr[j]%i==0) cut+=(div-1);
					else cut+=div;
				}
				
				long cost = (div*w*i)-(cut*c);
				if(cost>0) total+=cost;
			}
			
			result = Math.max(result, total);
		}
		
		System.out.println(result);
		
	}
	
}