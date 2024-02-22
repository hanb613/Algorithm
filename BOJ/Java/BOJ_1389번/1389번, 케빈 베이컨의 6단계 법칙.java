import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, minCnt, sum, ret;
	static ArrayList<Integer>[] graph;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n];
		dist = new int[n];
		
		minCnt = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int x, y;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			graph[x].add(y);
			graph[y].add(x);
		}

		for(int i=0; i<n; i++) {
			int cnt = BFS(i);
			
			if(minCnt > cnt) {
				minCnt = cnt;
				ret = i+1;
			}
		}
		
		System.out.println(ret);
	}
	
	private static int BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n];
		
		q.add(s);
		sum = 0;
		dist[s] = 0;
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int i=0; i<graph[p].size(); i++) {
				int now = graph[p].get(i);
				
				if(visited[now]) continue;
				
				visited[now] = true;
				dist[now] = dist[p] + 1;
				sum+=dist[now]; // 이동 횟수 누적
				q.add(now);
			}
		}
		
		return sum;
	}
}