import java.io.*;
import java.util.*;

public class Main {

	static int n, m, result;
	static String str;
	static boolean[] btn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		btn = new boolean[10];
		result = Math.abs(100-n);
		
		if(m!=0) {
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<m; i++) {
				btn[Integer.parseInt(st.nextToken())] = true;
			}			
		}
		
		for(int i=0; i<=999999; i++) {
			boolean chk = false;
			str = Integer.toString(i);
			
			for(int j=0; j<str.length(); j++) {
				if(btn[str.charAt(j)-'0']) { // 고장난 버튼
					chk = true; break;
				}
			}
			
			if(!chk) { // 채널 N으로 이동하기 위한 버튼 수 
				result = Math.min(result, str.length()+Math.abs(i-n));
			}
		}
		
		System.out.println(result);
	}
	
}