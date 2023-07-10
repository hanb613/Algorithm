import java.util.*;
import java.io.*;

public class Main{
	
	static int n, m, a, b, c, result;
	static int start, end;
	static int[][] graph;
	static int[] distance; // 최단 거리 저장
	static boolean[] visited; // 해당 노드 방문했는지 체크
	
	static final int INF = 987654321;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		distance = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				graph[i][j] = INF;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		visited[start] = true; // 방문처리
		
		// 시작점에서의 distance 배열 초기화
		for(int i=1; i<n+1; i++) {
			distance[i] = graph[start][i];
		}
		
		for(int i=1; i<n+1; i++) {
			int minVal = INF;
			int idx = 1;
			
			// 방문하지 X 정점 중 가장 작은 비용의 정점
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && minVal > distance[j]) {
					idx = j;
					minVal = distance[j];
				}
			}
			
			visited[idx] = true; // 방문처리
			for(int j=1; j<n+1; j++) { // 다른 노드 거쳐서 가는게 더 적은지 확인
				if(!visited[j] && graph[idx][j] != INF) {
					if(distance[j] > distance[idx] + graph[idx][j]) {
						distance[j] = distance[idx] + graph[idx][j];
					}
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}