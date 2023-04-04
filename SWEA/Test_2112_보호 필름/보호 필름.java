import java.io.*;
import java.util.*;


public class Solution{

	static int tc, d, w, k;
	static int result;
	static int[][] arr, tmpArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			result=100000;
			arr = new int[d][w];
			tmpArr = new int[d][w];
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					tmpArr[i][j] = arr[i][j]; // 배열 복사해놓기
				}
			}
			
			if(check()) { // 약품 투입 X -> 성능 검사
				System.out.println(String.format("#%d %d", T, 0));
			} else { // 약품 투입
				select(0, 0);
				System.out.println(String.format("#%d %d", T, result));
			}
		}
	}
	
	// 합격 기준 판단
	private static boolean check() {
		for(int i=0; i<w; i++) {
			int count=1, ret=0;
			int prev = arr[0][i];
			
			for(int j=1; j<d; j++) {
				if(prev == arr[j][i]) count++;
				else count=1;
				
				prev=arr[j][i]; // 이전 번호 저장
				ret = Math.max(ret, count);
			}
			if(ret<k) return false; // 합격기준 미달
		}
		
		return true; // 합격 !
	}
	
	private static void select(int layer, int cnt) {
		if(cnt>=result) return; // result보다 크거나 같으면 X, 바로 리턴
		
		if(layer==d) {
			if(check()) {
				result = Math.min(result, cnt);
			}
			return;
		}
		
		// 아무것도 안넣을래
		select(layer+1, cnt);
		
		// A 넣을래
		for(int j=0; j<w; j++) {
			arr[layer][j]=0;
		}
		select(layer+1, cnt+1);
		
		// B넣을래
		for(int j=0; j<w; j++) {
			arr[layer][j]=1;
		}
		select(layer+1, cnt+1);
		
		// 되돌리기
		for(int j=0; j<w; j++) {
			arr[layer][j]=tmpArr[layer][j];
		}
	}
}