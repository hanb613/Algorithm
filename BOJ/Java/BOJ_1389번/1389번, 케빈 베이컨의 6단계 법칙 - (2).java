import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, minCnt, sum, ret;
	static int[][] dist;
	
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dist = new int[n][n];
		
		minCnt = INF;
		
		// 배열 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				
				dist[i][j] = INF;
			}
		}
		
		// 양방향 그래프
		int x, y;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			dist[x][y] = dist[y][x] = 1;
		}
		
		// 플로이드 와샬
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) { // 최단 경로 
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		// 케빈 베이컨 수 계산
		for(int i=0; i<n; i++) {
			sum=0;
			
			for(int j=0; j<n; j++) {
				sum+=dist[i][j];
			}
			
			if(minCnt > sum) {
				minCnt = sum;
				ret = i+1;
			}
		}
		
		System.out.println(ret);
	}
}