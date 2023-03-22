import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, result;
	static boolean arr[][];

	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        arr = new boolean[101][101];
        
        n = Integer.parseInt(br.readLine());
        int x, y, d, g;
        for (int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			solve(x, y, d, g);
		}
        
        for (int i=0; i<100; i++) {
        	for (int j=0; j<100; j++) {
    			if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1])
    				result++;
    		}
		}
        
        System.out.println(result);
    }
    
	private static void solve(int c, int r, int d, int g) {
		ArrayList<Integer> dir = new ArrayList<Integer>();
		dir.add(d);
		
		for (int i=0; i<g; i++) {
			for (int j = dir.size()-1; j>=0; j--) {
				dir.add((dir.get(j)+1)%4);
			}
		}
		arr[r][c] = true;
		
		for (int i = 0; i < dir.size(); i++) {
			r+=dx[dir.get(i)];
			c+=dy[dir.get(i)];
			arr[r][c] = true;
		}
	}
}