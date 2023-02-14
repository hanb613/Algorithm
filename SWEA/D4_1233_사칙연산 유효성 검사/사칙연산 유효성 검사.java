import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int n, result;
	public static String[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<=10; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new String[n+1];
			result = 1;
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken()); 
				arr[num]=st.nextToken();
			}
			
			int idx = n/2; // idx보다 크면 리프노드
			for (int i=1; i<=n; i++) {
				if (arr[i].charAt(0)>='0' && arr[i].charAt(0)<='9') {
					if (i<=idx) { // 리프노드가 아닌데 숫자
						result = 0;
						break;
					}
				}
				else {
					if (i>idx) { // 리프노드에 연산자 X
						result = 0;
						break;
					}
				}
			}
			
			System.out.println(String.format("#%d %d", tc, result));
		}
	}
}