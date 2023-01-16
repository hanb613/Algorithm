package Algorithm;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, max, min, result;
	static StringTokenizer st;
	static int[] oper;
	static int[] arr, operCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		operCnt = new int[4]; // 연산자 수 
		oper = new int[n-1]; // 연산자 넣을 배열
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operCnt[i] = Integer.parseInt(st.nextToken()); // 연산자 수
		}
		
		Solution(0, operCnt, oper);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void Solution(int k, int[] cnt, int[] op) {
		if(k==n-1) {
			result = arr[0]; // 맨 처음에 들어있는 수
			
			for(int i=1; i < n; i++) {
				if(op[i-1]==0) {
					result += arr[i];
				}
				else if(op[i-1]==1) {
					result -= arr[i];
				}
				else if(op[i-1]==2) {
					result *= arr[i];
				}
				else {
					result /= arr[i];
				}
			}
			
			min = Math.min(min, result);
			max = Math.max(max, result);
		}
		
		for(int i=0; i<4; i++) {
			if(cnt[i] == 0) continue; // 연산자 없으면 아래 실행 X
			
			cnt[i]-=1; // 연산자 수 감소
			op[k] = i; // 연산자 넣기
			Solution(k+1, cnt, op);
			cnt[i]+=1; // 연산자 돌려넣기
			
		}
	}
}
