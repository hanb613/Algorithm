import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] arr, result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
		
			if(k==0) break;
			
			arr = new int[k];
			result = new int[6];
			
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Solution(0, 0);
			System.out.println();
			
		}
	}
	
	public static void Solution(int n, int pre) {
		if(n==6) {
			for(int i=0; i<6; i++) {
				System.out.print(String.format("%d ", result[i]));
			}
			System.out.println();
			return;
		}
		
		for(int i=pre; i<k; i++) {
			result[n]=arr[i];
			Solution(n+1, i+1);
		}
		
	}
}