import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int TC=1; TC<=10; TC++) {
		
			n = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			
			StringTokenizer st;
			int sx =0, sy=0;
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						sx=i; sy=j;
					}
				}
			}
			
			boolean left=false, right=false;
			while(true) {
				if(sx-1<0) break;
				if(!left && (sy-1)>=0 && arr[sx][sy-1]==1) { // 왼쪽 방문X + 범위 안 + 1일떄
					sy--; right = true; // 왼쪽으로 이동, 오른쪽 방문 체크
					continue;
				}
				else if(!right && (sy+1)<100 && arr[sx][sy+1]==1) {
					sy++; left = true; // 오른쪽으로 이동, 왼쪽 방문 체크
					continue;
				}
				sx--; // 위로 이동
				left=false; right=false;
			}
			
			System.out.println(String.format("#%d %d", TC, sy));
		}
	}
}
