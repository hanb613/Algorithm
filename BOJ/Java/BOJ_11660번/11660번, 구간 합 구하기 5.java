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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        int[][] sum = new int[n][n+1];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		sum[i][j+1] = sum[i][j] + arr[i][j];
        	}
        }
        
        for(int t=0; t<m; t++) {
        	int result=0;
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for(int i=x1-1; i<=x2-1; i++) {
            	result += sum[i][y2]-sum[i][y1-1];
        	}
        	bw.write(result+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}