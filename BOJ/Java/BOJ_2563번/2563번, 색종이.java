import java.io.*;
import java.util.*;

public class Main {
	
	static int n, r, c, result;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		visit = new boolean[101][101];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			for(int x=r; x<r+10; x++) {
				for(int y=c; y<c+10; y++) {
					if(!visit[x][y]) {
						visit[x][y]=true;
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}