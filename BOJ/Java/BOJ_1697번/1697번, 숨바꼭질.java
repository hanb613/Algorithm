import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] arr;
	static boolean[] visit;
	
	static final int N = 100000;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	arr = new int[N+1];
    	visit = new boolean[N+1];
    	
    	BFS(n);
    	
    	System.out.println(arr[k]);
    }
    
    
    private static void BFS(int x) {
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(x);
    	visit[x]=true;
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		if(cur+1<=N && !visit[cur+1]) {
    			visit[cur+1]=true;
    			arr[cur+1] = arr[cur]+1;
    			q.offer(cur+1);
    		}
        	
    		if(cur*2<=N && !visit[cur*2]) {
    			visit[cur*2]=true;
    			arr[cur*2] = arr[cur]+1;
    			q.offer(cur*2);
    		}
    		
    		if(cur-1>=0 && !visit[cur-1]) {
    			visit[cur-1]=true;
    			arr[cur-1] = arr[cur]+1;
    			q.offer(cur-1);
    		}
    	}
    }
}