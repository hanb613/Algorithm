import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, result;
	static int[] price, month;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			price = new int[4];
			month = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			result=price[3]; // 디폴트 = 1년 이용권
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			DFS(1, 0);
			
			System.out.println(String.format("#%d %d", t, result));
		}
	}
	
	private static void DFS(int k, int sum) {
		if(result<=sum) return; // 최소비용보다 커지면 X
		if(k>12) {
			result=Math.min(result, sum); 
			return;
		}
		
		if(month[k]!=0) {
			DFS(k+1, sum+(price[0]*month[k])); // 1일 => sum+(1일 이용권 요금 * 이용할 날)
			DFS(k+1, sum+price[1]); // 1달 => sum + 1달 요금
			DFS(k+3, sum+price[2]); // 3달 => sum + 3달 요금 
		}
		else DFS(k+1, sum); // 이용할 날 X => 0일 떄
	}
}
