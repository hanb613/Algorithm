import java.util.*;
import java.io.*;


public class Main{

	static int n, total, result;
	static int[] B;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		B = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			total+=B[i];
		}
		
		while(total>0) { 
			int cnt=0;
			for(int i=0; i<n; i++) {
				if(B[i]%2 == 1) { // 홀수 -> 1연산 필요
					cnt++; B[i]-=1;
				} 
			}
			if(cnt>0) { // 홀수 있었으면
				result+=cnt; total-=cnt;
			} else { // 짝수로만 이루어진거면
				result++; total/=2;
				for(int i=0; i<n; i++) {
					B[i]/=2;
				}
			}
		}
		
		System.out.println(result);
	}
}