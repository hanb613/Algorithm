import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k, result=Integer.MAX_VALUE;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int left=0, right=0, cnt=0;
		while(right<n) { // 오른쪽이 끝까지 갈 떄까지
			if(cnt>=k) { // 라인언이 k개 이상이면
				if(arr[left]==1) {
					result=Math.min(result, right-left);
					cnt--; 
				}
				left++; // 왼쪽 옮기기
			} else { // k개 보다 작고
				if(arr[right]==1) cnt++; // 오른쪽에 라이언 있으면 카운트
				right++; // 오른쪽 옮기기
			}
		}
		
		// 오른쪽은 끝까지 도달했을 때, 남은 왼쪽 -> 오른쪽으로 옮겨보기
		while(left<n) {
			if(cnt>=k) {
				if(arr[left]==1) {
					result=Math.min(result, right-left);
					cnt--;
				}
			}
			left++;
		}
		
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
}
