import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] degree;
	static ArrayList<Integer>[] list;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree=new int[n+1];
		list=new ArrayList[n+1];
		sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) list[i] = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			degree[y]++;
		}
		
		Solution();
		
		System.out.println(sb.toString());
		
	}
	
	private static void Solution() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			if(degree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int x : list[cur]) {
				if(--degree[x]==0) {
					q.offer(x);
				}
			}
		}
		
	}
}