import java.util.*;
import java.io.*;

public class Main {

	static int n, result;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n==1) {
			System.out.println("A");
		} else if(n==2) {
			if(arr[0]==arr[1]) {
				System.out.println(arr[1]);
			} else {
				System.out.println("A");
			}
		} else {
			int a, b;
			
			if(arr[1]==arr[0]) { // division by zero
				a = 1; 
				b = 0;
			} else {
				a = (arr[2]-arr[1]) / (arr[1]-arr[0]);
				b = arr[1] - (arr[0]*a);
			}

			for(int i=0; i<n-1; i++) { // 모든 원소가 규칙을 만족하는지 확인
				if(arr[i+1] != (arr[i]*a)+b) {
					System.out.println("B");
					return;
				}
			}
			
			System.out.println((arr[n-1]*a)+b);
		}
	}
	
}