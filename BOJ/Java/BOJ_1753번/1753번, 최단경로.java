import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e, k, result;
	static ArrayList<Data> list[];
	static boolean[] visited;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        
        distance = new int[v+1];
		visited = new boolean[v+1];
		list = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }
		
		int U, V, W;
        for(int i=0; i<e; i++) {
        	st = new StringTokenizer(br.readLine());
        	U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list[U].add(new Data(V, W));
        }
		
		Arrays.fill(distance, INF);
		distance[k]=0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(k, 0));

		Data cur;
		while(!pq.isEmpty()) {
			
			cur = pq.poll();
			if(visited[cur.idx]) continue;
			
			visited[cur.idx] = true;
						
			for(Data o : list[cur.idx]) {
				if(distance[o.idx] > o.w + distance[cur.idx]) {
					distance[o.idx] = o.w + distance[cur.idx];
					pq.offer(new Data(o.idx, distance[o.idx]));
				}
			}
		}
		 
		for(int i=1; i<=v; i++) {
        	if(distance[i]==Integer.MAX_VALUE) {
        		System.out.println("INF");
        	} else System.out.println(distance[i]);
        }
	}
	

	static class Data implements Comparable<Data> {
		int idx, w;

		public Data(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}
		
		@Override
		public int compareTo(Data o) {
			return Integer.compare(w, o.w);
		}
	}
}