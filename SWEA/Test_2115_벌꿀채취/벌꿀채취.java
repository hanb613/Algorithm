import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 *  꿀을 채취할 수 있는 벌통의 수 M -> 가로로 M개 연속
 *  	- 두 명의 일꾼이 선택한 벌통은 서로 겹치면 X
 *  두 일꾼이 채취할 수 있는 꿀의 최대 양 C
 *  
 *  수익 = 각 용기에 있는 꿀의 양의 제곱
 *  
 * */
public class Solution {
	
	static int tc, n, m, c, result;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine().trim());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			result =0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			select();
			
			System.out.println(String.format("#%d %d", T, result));
		}
	}
	
	static int maxVal=0; // 각 부분집합 -> 최대값
	private static void select() {
		
		int tmpA, tmpB;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=n-m; j++) {
				
				// 일꾼 A
				tmpA=maxVal=0;
				subset(i, j, 0, 0, 0); // j열에서 벌통을 선택했을 때, 
				tmpA = Math.max(maxVal, tmpA); // 일꾼 A 최대값
				
				// 일꾼 B
				tmpB=maxVal=0;
				for(int r=i+1; r<n; r++) { // A가 선택한 다음 행에서 선택
					for(int c=0; c<=n-m; c++) {
						subset(r, c, 0, 0, 0);
						tmpB = Math.max(maxVal, tmpB); // 일꾼 B 최대값
					}
				}
				
				for(int c=j+m; c<=n-m; c++) { // A가 선택한 다음 열에서 선택
					subset(i, c, 0, 0, 0);
					tmpB = Math.max(maxVal, tmpB); // 일꾼 B 최대값
				}
				
				result = Math.max(result, tmpA+tmpB); // 최대값 갱신
			}
		}
	}
	
	private static void subset(int row, int col, int cnt, int sum, int total) { // 부분집합
		if(sum>c) return; // 채취할 수 있는 최대 양이 넘어서면 리턴
		
		if(cnt==m) { // 선택할 수 있는 벌통의 개수를 채웠다면 ? 최대값 갱신 후 리턴
			maxVal = Math.max(maxVal, total);
			return;
		}
		
		subset(row, col+1, cnt+1, sum+(arr[row][col]), total+(arr[row][col]*arr[row][col])); // 벌꿀 채취 O
		subset(row, col+1, cnt+1, sum, total); // 벌꿀 채취 X
	}
}