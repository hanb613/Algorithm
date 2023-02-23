import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, ret;
	static int[][] arr;
	static boolean[][] visit;
	static ArrayList<Integer> result;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	n = Integer.parseInt(br.readLine());
    	arr = new int[n][n];
    	visit = new boolean[n][n];
    	result = new ArrayList<>();
    	
    	String str;
    	for(int i=0; i<n; i++) {
    		str = br.readLine();
    		for(int j=0; j<n; j++) {
    			arr[i][j] = str.charAt(j)-'0';
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(!visit[i][j] && arr[i][j]==1) {
    				ret=1;
        			BFS(i, j);
        			result.add(ret);
    			}
    		}
    	}
    	
    	Collections.sort(result);
    	System.out.println(result.size());
    	for(int i=0; i<result.size(); i++) {
    		System.out.println(result.get(i));
    	}
    }
    
    
    private static void BFS(int x, int y) {
    	Queue<Pair> q = new LinkedList<>();
    	q.offer(new Pair(x, y));
    	visit[x][y]=true;
    	
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		
    		for(int d=0; d<4; d++) {
    			int nx=p.x+dx[d];
    			int ny=p.y+dy[d];
    			
    			if(nx<0 || ny<0||nx>=n || ny>=n || visit[nx][ny]) continue;
    			
    			if(arr[nx][ny]==1) {
    				q.offer(new Pair(nx, ny));
        			visit[nx][ny]=true;    			
        			ret++;
    			}
    		}
    	}
    }
    
    private static class Pair{
    	int x, y;
    	public Pair(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}
    }
}