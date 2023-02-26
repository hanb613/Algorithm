import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h, result;
	static int[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());	
			w = Integer.parseInt(st.nextToken());	
			if(h==0 && w==0) break;
			
			arr = new int[w][h];
			visit = new boolean[w][h];
			result=0;
			
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<h; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());	
				}
			}
			
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					if(!visit[i][j] && arr[i][j]==1) {
						result++;
						DFS(i, j);
						
					}
				}
			}
			System.out.println(result);
		}
	}
	
	private static void DFS(int x, int y) {
		visit[x][y]=true;
		
		for(int i=0; i<8; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0 || ny<0 || nx>=w || ny>=h) continue;
			
			if(arr[nx][ny]==1 && !visit[nx][ny]) {
				DFS(nx, ny);
			}
		}	
	}
	
}
