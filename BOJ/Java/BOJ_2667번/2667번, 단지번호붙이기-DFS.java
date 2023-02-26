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
	
	static int n, m, result;
	static int[][] arr;
	static boolean[][] visit;
	static List<Integer> list;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	
			
		arr = new int[n][n];
		visit = new boolean[n][n];
		list = new ArrayList<Integer>();
		
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
					result=0;
					DFS(i, j);
					list.add(result);
				}
			}
		}	
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	
	private static void DFS(int x, int y) {
		visit[x][y]=true;
		result++;
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			
			if(arr[nx][ny]==1 && !visit[nx][ny]) {
				DFS(nx, ny);
			}
		}	
	}
	
}
