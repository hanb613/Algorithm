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
	
	static int n, m, cnt, result;
	static int[][] arr;
	static int[][] visit;
	static Queue<Data> tomato;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
					
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		result=0;
		arr = new int[n][m];
		visit = new int[n][m];
		tomato = new LinkedList<Data>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
				if(arr[i][j]==1) tomato.add(new Data(i, j));
				else if(arr[i][j]==0) cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(0);
		} else {
			BFS();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]==0) {
						System.out.println(-1);
						System.exit(0);
					}
					result = Math.max(result, arr[i][j]);
				}
			}
			System.out.println(result-1);
		}
	}
	
	private static void BFS() {
		
		while(!tomato.isEmpty()) {
			Data q = tomato.poll();
			visit[q.x][q.y] = 1;
			cnt--;
			
			for(int d=0; d<4; d++) {
				int nx = q.x+dx[d];
				int ny = q.y+dy[d];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(visit[nx][ny]==1) continue;
				
				if(arr[nx][ny]==0) {
					arr[nx][ny]=arr[q.x][q.y]+1;
					tomato.offer(new Data(nx, ny));
				}
			}
		}
	}
	
	private static class Data{
		int x, y;
		public Data(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
