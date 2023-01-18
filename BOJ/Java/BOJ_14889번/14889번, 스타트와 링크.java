import java.io.*;
import java.util.*;

public class Main {
	
	static int n, result;
	static int[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n];
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Solution(0, 0);
		
		System.out.println(result);
	}
	
	public static void Solution(int cnt, int k) {
		if(cnt == n/2) { // 팀이 다 나눠졌을 떄
			int start = 0; // visit = true
			int link = 0; // visit = false

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(visit[i] && visit[j]) start+=arr[i][j];
					if(!visit[i] && !visit[j]) link+=arr[i][j];
				}
			}
			result = Math.min(result, Math.abs(start - link));
		}
		
		for(int i=k; i<n; i++) {
			if(!visit[i]) {
				visit[i]=true; // 뽑힌 사람
				Solution(cnt+1, i+1);
				visit[i]=false;
			}
		}
		
	}
}