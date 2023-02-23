import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, a, b, k, x, y, result;
    static List<Data>[] graph;
    static boolean[] visit;    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        k = Integer.parseInt(br.readLine());
        
        visit = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<Data>();
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(new Data(y, 1));
            graph[y].add(new Data(x, 1));
        }
        
        BFS(a);
        
        if(!visit[b]) System.out.println(-1);
        else System.out.println(result);
    }
    
    private static void BFS(int s) {
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(s, 1));
        visit[s]=true;
        
        while(!q.isEmpty()) {
            Data cur = q.poll();
            
            for(int i=0; i<graph[cur.num].size(); i++) {
                int ng = graph[cur.num].get(i).num;
                
                if(ng==b) {
                	visit[ng]=true;
                	result= cur.depth;
                	return;
                }
                if(!visit[ng]) {
                    q.offer(new Data(ng, cur.depth+1));
                    visit[ng]=true;
                }
            }
        }
    }
    
    private static class Data{
    	int num, depth;
		public Data(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
    }
}