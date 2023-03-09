import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static Node[] adjList;
	static int[] degree;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		result = new ArrayList<Integer>();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adjList = new Node[n+1];
		degree = new int[n+1];
		
		int num, from, to;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			num = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			for(int j=1; j<num; j++) {	
				to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				degree[to]++;
				from=to;
			}
		}
		
		topologySort();
		
		if(result.size()!=n) {
			System.out.println(0);
		} else {
			for(int i : result) {
				System.out.println(i);
			}
		}
	}
	
	private static void topologySort(){
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			if(degree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			
			for(Node temp = adjList[cur]; temp!=null; temp=temp.link) {
				if(--degree[temp.vertex]==0) {
					q.offer(temp.vertex);
				}
			}
		}
	}
	
	private static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
}