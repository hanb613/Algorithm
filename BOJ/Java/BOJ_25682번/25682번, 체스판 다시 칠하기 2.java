import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k, result;
	static int[][] black, white;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		black = new int[n+1][m+1];
		white = new int[n+1][m+1];
		result = 4000001;
		
		String str ="";
		for(int i=1; i<=n; i++) {
			str = br.readLine();
			for(int j=1; j<=m; j++) {
				if(str.charAt(j-1)=='B') { // 이전이 검
					if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
						// 흰
						white[i][j] = white[i-1][j] + white[i][j-1] - white[i-1][j-1]+1;
						black[i][j] = black[i-1][j] + black[i][j-1] - black[i-1][j-1];
					} else {
						// 검
						white[i][j] = white[i-1][j] + white[i][j-1] - white[i-1][j-1];
						black[i][j] = black[i-1][j] + black[i][j-1] - black[i-1][j-1]+1;
					}
				} else { // 이전이 흰
					if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
						// 검
						white[i][j] = white[i-1][j] + white[i][j-1] - white[i-1][j-1];
						black[i][j] = black[i-1][j] + black[i][j-1] - black[i-1][j-1]+1;
					} else {
						// 흰
						white[i][j] = white[i-1][j] + white[i][j-1] - white[i-1][j-1]+1;
						black[i][j] = black[i-1][j] + black[i][j-1] - black[i-1][j-1];
					}
				}
			}
		}
		
		for(int i=0; i<=n-k; i++) {
			for(int j=0; j<=m-k; j++) {
				int minW = white[i+k][j+k] - white[i][j+k] - white[i+k][j] + white[i][j];
				int minB = black[i+k][j+k] - black[i][j+k] - black[i+k][j] + black[i][j];

				result = Math.min(Math.min(minW, minB), result);
			}
		}

		
		System.out.println(result);
	}
}
