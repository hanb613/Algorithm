import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		int maxHeight = 0;
		int minHeight = 256;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				maxHeight = Math.max(maxHeight, arr[i][j]); // 제일 높은 땅
				minHeight = Math.min(minHeight, arr[i][j]); // 제일 낮은 땅
			}
		}
		
		int resultS = Integer.MAX_VALUE;
		int resultH = Integer.MIN_VALUE;
		
		for(int i=minHeight; i<=maxHeight; i++) { // 최종 높이는 min ~ max 사이에서 나옴
			int s = 0; // 걸린 시간
			int inv = b; // 인벤토리
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					int diff = arr[j][k] - i; // 현재 땅과 i(min~max) 차이
					
					if(diff>0) { // 현재 땅이 높음 => 없애야 됨
						inv+=Math.abs(diff); // 차이만큼 이벤에 넣기
						s+=Math.abs(diff)*2; // 차이 * 2초
					}
					else if(diff<0){ // 현재 땅이 낮음 => 채워야 됨
						inv-=Math.abs(diff); // 차이만큼 이벤에서 뺴기
						s+=Math.abs(diff); // 차이  * 1초
					}
				}
			}
			
			if(inv>=0 && s <= resultS) { // 인벤에 남은 개수가 음수 X, 최소 시간 일 떄  
				resultS = s; // 최소 시간으로,
				resultH = i; // 더 큰 높이로 갱신
            }
		}
		
		System.out.println(resultS + " " + resultH);
	}
}