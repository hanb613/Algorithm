import java.io.*;
import java.util.*;

public class Solution{

	static int n, tc;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for(int t=1 ; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			if(n%2==0) {
				sb.append("#").append(t).append(" Alice\n");
			} else {
				sb.append("#").append(t).append(" Bob\n");
			}
		}
		System.out.println(sb.toString());
	}
}