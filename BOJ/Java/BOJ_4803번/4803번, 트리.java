import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int tc, n, m, cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		graph = new ArrayList[501];
		visited = new boolean[501];
		
		for(int i=0; i<501; i++) {
			graph[i] = new ArrayList<>();
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());	
			
			if(n==0 && m==0) break;
			
			tc++; cnt=0;
			
			for(int i=0; i<501; i++) {
				graph[i].clear();
				visited[i] = false;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for(int i=0; i<n; i++) {
				if(!visited[i] && Solution(i, -1)) {
					cnt++;
				}
			}
			
			if(cnt==0) {
				System.out.println("Case " + tc + ": No trees.");
			} else if(cnt==1) {
				System.out.println("Case " + tc + ": There is one tree.");
			} else {
				System.out.println("Case " + tc + ": A forest of " + cnt + " trees.");
			}
		}
    }
	
	private static boolean Solution(int k, int before) {
		
		if(visited[k]) return false;
		
		visited[k] = true;
		
		for(int i=0; i<graph[k].size(); i++) {
			if(graph[k].get(i) != before) {
				if(!Solution(graph[k].get(i), k)) return false;				
			}
		}
		
		return true;
	}
}