import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, k;
	static int a, b, c, d;
	static int[][][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][m+1][3];
		
		String str = "";
		for(int i=1; i<=n; i++) {
			str = br.readLine();
			
			for(int j=1; j<=m; j++) {
				for(int l=0; l<3; l++) {
					arr[i][j][l] = arr[i][j-1][l]; // 이전 열의 값 저장
				}
				
				if(str.charAt(j-1) == 'J') arr[i][j][0]++;
				else if(str.charAt(j-1) == 'O') arr[i][j][1]++;
				else if(str.charAt(j-1) == 'I') arr[i][j][2]++;
			}

			for(int j=1; j<=m; j++) {
				for(int l=0; l<3; l++) {
					arr[i][j][l]+=arr[i-1][j][l]; // 이전 행의 값 더함
				}
			}
		}
		
		// 조사 대상 영역 J, O, I 출력
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<3; j++) {
				sb.append(arr[c][d][j] - arr[a-1][d][j] - arr[c][b-1][j] + arr[a-1][b-1][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}