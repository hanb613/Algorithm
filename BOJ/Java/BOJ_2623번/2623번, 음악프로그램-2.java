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
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree=new int[n+1];
		list=new ArrayList[n+1];
		result = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) list[i] = new ArrayList<Integer>();
		
		int num, x, y;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			num = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			for(int j=1; j<num; j++) {
				y = Integer.parseInt(st.nextToken());
				list[x].add(y);
				degree[y]++;
				x=y;
			}
		}
		
		Solution();
		
		if(result.size()!=n) {
			System.out.println(0);
		} else {
			for(int i:result) {
				System.out.println(i);
			}
		}
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
			result.add(cur);
			
			for(int x : list[cur]) {
				if(--degree[x]==0) {
					q.offer(x);
				}
			}
		}
		
	}
}