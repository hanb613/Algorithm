import java.util.*;
import java.io.*;

public class Main {

	static int total, n, m, result;
	static int student[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		student = new int[m+1];
		result = 11;
		
		for (int i=1; i<=n; i++) {
			total = (total | (1 << i)); // 전체 문제 번호
		}
		
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cnt = Integer.parseInt(st.nextToken());
			int flag = 0;
			
			for (int j=1; j<=cnt; j++) {
				int p = Integer.parseInt(st.nextToken());
				flag = (flag | (1 << p));
			}
			
			student[i] = flag; // 각 학생이 풀수있는 문제 번호 저장
		}
		
		combination(1, 0, 0);
		
		if(result==11) result = -1;
		
		System.out.println(result);
	}

	private static void combination(int k, int cnt, int flag) {
		if (flag == total) {
			result = Math.min(result, cnt);
			return;
		}
		
		for (int i=k; i<=m; i++) {
			combination(i+1, cnt+1, (flag | student[i]));
		}
	}
	
}