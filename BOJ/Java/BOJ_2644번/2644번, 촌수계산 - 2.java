import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, retA, retB;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int[] num;

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		retA = Integer.parseInt(st.nextToken());
		retB = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1];
		num = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		int x, y;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		solve();
		
		if(num[retB]!=0) System.out.println(num[retB]);
		else System.out.println(-1);
		
	}
	
	private static void solve() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(retA);
		visit[retA]=true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(p==retB) return;
			
			for(int i=0; i<graph[p].size(); i++) {
				int now = graph[p].get(i);

				if(!visit[now]) {
					q.add(now);
					num[now] = num[p]+1;
					visit[now]=true;
				}
			}
		}
	}
}
