import java.util.*;
import java.io.*;

/*
 * 운영 비용 = K * K + (K - 1) * (K - 1)
 * 이익 = (M * 집 수) - 운영비용
 * 손해를 보지 않고 많은 집에 서비스 제공
 * */

public class Solution {
	
	static int tc, n, m, result;
	static int[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			result=0;
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// K = N+1만큼 가능
			for(int k=1; k<=n+1; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						Solve(i, j, k);
					}
				}
			}
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	private static void Solve(int x, int y, int k) {
		int house=0;
		
		//해당좌표로부터 K범위 확인
		for(int i=x-(k-1); i<=x+(k+1); i++) {
			for(int j=y-(k-1); j<=y+(k+1); j++) {
				if(Math.abs(x-i) + Math.abs(y-j) > k-1) continue; // 마름모 범위 안에 X
				if(i<0 || j<0 || i>=n || j>=n) continue; // 도시 범위 X
				
				if(arr[i][j]==1) house++; // 집이면 카운트
			}
		}
		
		if(house * m - calc(k) >=0) { // 비용 계산
			result = Math.max(result, house);
		}
	}
	
	private static int calc(int K) {
		return K * K + (K - 1) * (K - 1);
	}
}
