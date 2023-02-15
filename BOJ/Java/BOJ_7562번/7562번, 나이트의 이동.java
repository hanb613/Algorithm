import java.io.*;
import java.util.*;

public class Main {
    static int tc, n, startX, startY, endX, endY, result;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, -2, 2, 2, -2, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());	        
	        startX = Integer.parseInt(st.nextToken());
	        startY = Integer.parseInt(st.nextToken());
	        
	        st = new StringTokenizer(br.readLine());
	        endX = Integer.parseInt(st.nextToken());
	        endY = Integer.parseInt(st.nextToken());
	        BFS();
	        
	        System.out.println(arr[endX][endY]);
	    }
	}
	
	private static void BFS() {
	    Queue<Pair> q = new LinkedList<>();
	    q.offer(new Pair(startX, startY));
	    
	    while(!q.isEmpty()) {
	        Pair p = q.poll();
	        if(p.x==endX && p.y == endY) return;
	        
	        for(int i=0; i<8; i++) {
	            int nx = p.x + dx[i];
	            int ny = p.y + dy[i];
	            
	            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
	            if(!visit[nx][ny]) {
	                q.offer(new Pair(nx, ny));
	                arr[nx][ny]=arr[p.x][p.y]+1;
	                visit[nx][ny]=true;
	            }
	        }
	    }
	}
	
	private static class Pair{
	    int x, y;
	    public Pair(int x, int y){
	        this.x=x;
	        this.y=y;
	    }
	}
}