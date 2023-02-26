import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Main {
	
	static int tc, n, m, k, x, y, result;
	static int[][] arr;
	static boolean[][] visit;
	static List<Integer> list;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());	
			
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			result=0;
			arr = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
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
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			
			if(arr[nx][ny]==1 && !visit[nx][ny]) {
				DFS(nx, ny);
			}
		}
	}
}
