import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        int[] sum = new int[n+1];
        
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	       arr[i] = Integer.parseInt(st.nextToken());
	       sum[i+1] = sum[i]+arr[i];
	    }
	    
	    for(int i=0; i<m; i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	       
	        bw.write(sum[y]-sum[x-1]+"\n");
	    }
	    bw.flush();
	    bw.close();
    }
}