import java.io.*;
import java.util.*;

public class Main {

	static int n, m, x, y, k;
	static int[][] arr;
	static int[] dice;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[7]; // {X, 1,2,3,4,5,6}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int command = Integer.parseInt(st.nextToken());
			
			if(command==1) {
				if(y+1>=m) continue;
				int tmp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
				y++;
			} else if(command==2) {
				if(y-1<0) continue;
				int tmp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[4];
				dice[4] = tmp;
				y--;
			} else if(command==3) {
				if(x-1<0) continue;
				int tmp = dice[6];
				dice[6] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[5];
				dice[5] = tmp;
				x--;
			} else if(command==4) {
				if(x+1>=n) continue;
				int tmp = dice[1];
				dice[1] = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[2];
				dice[2] = tmp;
				x++;
			}
			
			if(arr[x][y]==0) {
				arr[x][y]=dice[5];
			} else {
				dice[5]=arr[x][y];
				arr[x][y]=0;
			}
			System.out.println(dice[1]);
		}
	}
}
