import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		boolean[] check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result=0;
		for(int i=0; i<n; i++) {
			if(check[i]) continue;
			
			int hole = arr[i] + l;
			check[i]=true;
			
			for(int j=i; j<n; j++) {
				if(arr[j]<hole) {
					check[j]=true;
				}
			}
			result++;
		}
		
		System.out.println(result);
	}
}