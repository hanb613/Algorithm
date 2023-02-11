import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<String> q = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				q.offer(st.nextToken());
			}
			
			boolean check=false;
			while(true) {
				if(check) break;
				for(int i=1; i<=5; i++) {
					int sub = Integer.parseInt(q.peek()) - i;
					q.poll();
					
					if(sub <= 0) {
						q.offer(0+"");
						check=true; break;
					}
					else {
						q.offer(sub+"");
					}
				}	
			}
			
			System.out.print(String.format("#%d ", n));
			
			for(int i=0; i<8; i++) {
				System.out.print(String.format("%s ", q.poll()));
			}
			System.out.println();
		}
		
	}
}