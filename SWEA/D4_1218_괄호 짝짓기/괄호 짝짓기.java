import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			Stack<String> st = new Stack<>();
			int result=0;
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			boolean check=true;
			for(int i=0; i<n; i++) {
				if(!check) break;
				
				String next = str.charAt(i)+"";
				if(next.equals("(") || next.equals("[") || next.equals("{") || next.equals("<")) {
					st.push(next);
				}
				else {
					if(st.peek().equals("(") && next.equals(")")) st.pop();
					else if(st.peek().equals("[") && next.equals("]")) st.pop();
					else if(st.peek().equals("{") && next.equals("}")) st.pop();
					else if(st.peek().equals("<") && next.equals(">")) st.pop();
					else check=false;
				}
			}
			if(!st.empty() || !check) result=0;
			else result=1;
			
			System.out.println(String.format("#%d %d", t, result));
		}
	}
}