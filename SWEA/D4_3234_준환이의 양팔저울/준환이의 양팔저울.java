import java.io.*;
import java.util.*;

public class Solution {
	static int n, result;
	static int[] arr, tmp;
	static boolean[] visited;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=tc; TC++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			result = 0;
			tmp = new int[n];
			visited = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solution(0);
			
			System.out.println(String.format("#%d %d", TC, result));
		}
	}
	
	public static void move(int k, int l, int r) {
		if(k == n) {
			result++;
			return;
		}
		
		move(k+1, l+tmp[k], r); // 왼쪽에 추 올리기
		
		if(r + tmp[k] <= l) { // 오른쪽에 추를 올렸을 때 왼쪽보다 총합이 작다면
			move(k+1, l, r + tmp[k]);	
		}
	}
	
	
	public static void solution(int k) {
		if(k == n) {
			move(0, 0, 0);
			return;
		}
		
		for(int i=0; i<n; i++) { // 순열
			if(!visited[i]) {
				visited[i]=true;
				tmp[k] = arr[i];
				solution(k+1);
				visited[i]=false;
			}
		}
	}
}
