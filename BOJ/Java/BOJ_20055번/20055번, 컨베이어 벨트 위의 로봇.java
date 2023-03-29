import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, k, result;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		belt = new int[n*2];
		robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n*2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			result++;
			
			/* 1. 벨트 + 로봇 한 칸 회전 */
			int tmp = belt[n*2-1];
			for (int i = n*2-1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;

			for (int i = n-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			
			robot[0] = false;
			robot[n-1] = false;
			
			/* 2. 가장 먼저 올라간 로봇부터 한 칸 이동 */
			for (int i = n-1; i > 0; i--) {
				if(robot[i-1] && !robot[i] && belt[i]>0) {
					belt[i]--;					
					robot[i] = true;
					robot[i-1] = robot[n-1] = false;
				}
			}
			
			/* 3. 올리는 위치에 내구도 0이 아니면 로봇 올림 */
			if(belt[0]>0) {
				belt[0]--;
				robot[0] = true;
			}
			
			/* 4. 내구도 0인 칸이 k개 이상이면 종료 */
			int cnt = 0;
			for (int i = 0; i < n*2; i++) {
				if(belt[i]==0) cnt++;
			}
			
			if(cnt>=k) break;
		}
		
		System.out.println(result);
	}
}