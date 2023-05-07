import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[1001];
		
		arr[1]=1;
		arr[2]=3;
		
		for(int i=3; i<=1000; i++) {
			arr[i] = (arr[i-1]%10007 + (arr[i-2]*2)%10007) %10007;
		}
		
		System.out.println(arr[n]);
	}
}
