import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] result, check;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		check = new int[n+1];
		
		Solution(0, 1);
		
		bw.flush();
		bw.close();
	}
	
	public static void Solution(int k, int pre) throws IOException {
		if(k==m) {
			for(int i=0; i<m; i++) {
				bw.write(result[i]+ " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(i<pre) continue;
			
			if(check[i]==0) {
				check[i]=1;
				result[k]=i;
				Solution(k+1, i);
				check[i]=0;
			}
		}
		
	}
}
