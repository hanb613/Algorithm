import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int l, c;
	static String[] arr, result;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new String[c];
		result = new String[l];
		visit= new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken();	
		}
		
		Arrays.sort(arr);
		
		Solution(0, 0);
	}
	
	public static void Solution(int k, int prev) {
		if(k==l) {
			int check=0, checkV=0;
			
			for(int i=0; i<l; i++) {
				if(result[i].equals("a") || result[i].equals("e")||
						result[i].equals("i")|| result[i].equals("o")|| result[i].equals("u")) checkV++;
				else check++;
			}
			if(checkV>=1 && check>=2) {
				for(String s : result) {
					System.out.print(s);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=k; i<c; i++) {
			if(i<prev) continue;
			if(!visit[i]) {
				visit[i]=true;
				result[k]=arr[i];
				Solution(k+1, i);
				visit[i]=false;
			}
		}
	}
}
