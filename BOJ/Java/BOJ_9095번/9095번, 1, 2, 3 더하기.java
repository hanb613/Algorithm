import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int n, tc, result;
	static int arr[];
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	tc=Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<tc; i++) {
    		n=Integer.parseInt(br.readLine());
    		result=0;
    		Solution(0);
    		System.out.println(result);
    	}
    }
    
    private static void Solution(int sum) {
    	if(sum>n) return;
    	if(sum==n) {
    		result++; return;
    	}
    	
    	for(int i=1; i<=3; i++) {
    		Solution(sum+i);
    	}
    }
}