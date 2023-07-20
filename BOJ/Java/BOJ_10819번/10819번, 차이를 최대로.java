import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, result;
	static int[] arr, num;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		num = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		Solution(0);
		
		System.out.println(result);
	}
	
	private static void Solution(int k) {
		if(k==n) {
			int sum=0;
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(num[i]-num[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[k]=arr[i];
				Solution(k+1);
				visited[i] = false;
			}
		}
		
	}
}