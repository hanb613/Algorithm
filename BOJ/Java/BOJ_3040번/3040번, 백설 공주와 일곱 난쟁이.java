import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = 0;
        arr = new int[9];
        for(int i=0; i<9; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	total+=arr[i];
        }

        for(int i=0; i<9; i++) {
        	for(int j=i+1; j<9; j++) {
        		if(total - arr[i] -arr[j] == 100) {
        			for(int k=0; k<9; k++) {
        	        	if(i==k || j==k) continue;
        	        	System.out.println(arr[k]);
        	        }
        		}
        	}
        }
    }
}