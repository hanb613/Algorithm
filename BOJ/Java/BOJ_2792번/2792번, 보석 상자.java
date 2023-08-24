import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1, right=arr[m-1];
		while(left<=right){
			int mid = (left+right)/2;
			
			int sum=0;
			for(int i=0; i<m; i++) {
				if(arr[i]%mid==0) sum+=(arr[i]/mid);
				else sum+=(arr[i]/mid)+1;
			}
			
			if(sum<=n) {
				result = Math.min(result, mid);
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		System.out.print(result);
	}
}
