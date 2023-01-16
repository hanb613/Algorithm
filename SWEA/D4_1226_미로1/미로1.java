import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int result;
	static int[] dx;
	static int[] dy;
	static int[][] arr;
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		dx = new int[] {1, 0, -1, 0};
		dy = new int[] {0, -1, 0, 1};
		
		for(int TC=1; TC<=10; TC++) {
			int n = Integer.parseInt(br.readLine());
			result=0;
			arr = new int[16][16];
			visit = new boolean[16][16];
			
			for(int i=0; i<16; i++) {
				String str = br.readLine();
				for(int j=0; j<16; j++) {
					arr[i][j]=str.charAt(j)-'0';
				}
			}
			
			DFS(1,1);
			
			System.out.println(String.format("#%d %d", TC, result));
		}
	}
	
	static public void DFS(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int new_x = x+dx[i];
			int new_y = y+dy[i];
			
			if(new_x < 0 || new_x >= 16 || new_y < 0 || new_y >= 16) continue;
			
			if(!visit[new_x][new_y]) {
				if(arr[new_x][new_y] == 0) {
					DFS(new_x, new_y);
				}
				
				if(arr[new_x][new_y] == 3) {
					result=1;
					return;
				}
			}
		}
	}

}
