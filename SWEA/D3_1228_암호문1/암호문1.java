import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			List<String> str = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				str.add(st.nextToken());
			}
			
			int oper = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			
			for(int k=0; k<oper; k++) {
				String s = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				for(int i=0; i<y; i++) {
					str.add(x+i, st.nextToken());
				}
			}
			
			System.out.print(String.format("#%d ", t));
			for(int i=0; i<10; i++) {
				System.out.print(str.get(i)+" ");
			}
			System.out.println();
		}
		
	}
}