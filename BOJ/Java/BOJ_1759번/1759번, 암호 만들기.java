import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int l, c;
	static String[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new String[c];
		visit= new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken();	
		}
		
		Arrays.sort(arr);
		
		Solution(0, 0, "");
	}
	
	public static void Solution(int k, int prev, String str) {
		if(k==l) {
			int check=0, checkV=0;
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='a' || str.charAt(i)=='e'||
					str.charAt(i)=='i'|| str.charAt(i)=='o'||str.charAt(i)=='u') checkV++;
				else check++;
			}
			if(checkV>=1 && check>=2) {
				System.out.println(str);
			}
			return;
		}
		
		for(int i=k; i<c; i++) {
			if(i<prev) continue;
			if(!visit[i]) {
				visit[i]=true;
				Solution(k+1, i, str+arr[i]);
				visit[i]=false;
			}
		}
	}
}
