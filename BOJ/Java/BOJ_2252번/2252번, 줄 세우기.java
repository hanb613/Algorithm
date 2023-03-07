import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static int n, m;
	static Node[] adjList;
	static int[] inDegree; // 진입차수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adjList = new Node[n+1];
		inDegree = new int[n+1];
		
		int from, to;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		ArrayList<Integer> list = topologySort();
		if(list.size()==n) {
			
			for(Integer vertex : list) {
				System.out.print(vertex + " ");
			}
			System.out.println();
			
		} else {
			System.out.println("Cycle");
		}
		
	}
	
	static ArrayList<Integer> topologySort(){
		
		ArrayList<Integer> orderList = new ArrayList<Integer>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for(int i=1; i<=n; i++) {
			if(inDegree[i]==0) q.offer(i);
		} // 진입 차수가 0인 정점 큐에 넣기
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			orderList.add(cur);
			
			// 현재 정점 기준으로 인접 정점 처리
			for(Node temp = adjList[cur]; temp!=null; temp=temp.link) {
				if(--inDegree[temp.vertex]==0) {
					q.offer(temp.vertex);
				}
			}
		}
		
		return orderList;
	}
}