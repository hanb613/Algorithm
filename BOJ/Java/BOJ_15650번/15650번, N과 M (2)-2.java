import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static BufferedWriter bw;
	static int[] num;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[m];
        
        DFS(0,0);
        
        bw.flush();
        bw.close();
    }
    
    private static void DFS(int k, int prev) throws IOException {
    	if(k==m) {
    		for(int ret : num) {
    			bw.write(ret+" ");
    		}
    		bw.newLine();
    		return;
    	}
    	
    	for(int i=prev; i<n; i++) {
			num[k]=i+1;
			DFS(k+1, i+1);
		}
	}
}