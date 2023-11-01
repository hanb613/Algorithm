import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, half, result;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		half = (n+1)/2;
		
		arr = new int[n][2];
		graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			graph[a].add(b);
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			DFS(i, i);
		}
		
		for(int i=0; i<n; i++) {
            if(arr[i][0]>=half || arr[i][1]>=half) {
                result++;
            }
		}
		
		System.out.print(result);
	}
	
	private static void DFS(int k, int cur) {
		
		visited[cur] = true;
		
		for(int i=0; i<graph[cur].size(); i++) {
			int next = graph[cur].get(i);
			
			if(!visited[next]) {
				arr[k][0]++; // 가벼운거
				arr[next][1]++; // 무거운거
				DFS(k, next);
			}
		}
	}
}
