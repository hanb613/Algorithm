import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	static int t, n, k;
	static long result;
	static String str;
	static TreeSet<String> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		for(int T=1; T<=t; T++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			str = br.readLine();
			
			list = new TreeSet<>(Collections.reverseOrder());
			
			int size=n/4;
			for(int k=0; k<size; k++) {
				StringBuilder tmp=new StringBuilder();
				for(int i=0; i<=n-size; i+=size) {
					StringBuilder sb=new StringBuilder();

					for(int j=i; j<i+size; j++) {
						sb.append(str.charAt(j));
					}
					list.add(sb.toString());
				}
			
				tmp.append(str.charAt(n-1));
				for(int m=0; m<n-1; m++) {
					tmp.append(str.charAt(m));
				}
				str=tmp.toString();
			}
			String ret[] = list.toArray(new String[list.size()]);
			
			result =Integer.parseInt(ret[k-1], 16);
			System.out.println(String.format("#%d %d", T, result));
		}
		
	}
}
