import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
	static int n;
	static long resultA, resultB, resultC;
	static long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arr = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);

        long minA = Long.MAX_VALUE;
        int left=0, right=0, mid=0;
        
        for(int i=0; i<n-2; i++) {
        	left = i;
        	mid = i+1;
        	right = n-1;
        	
        	while(mid < right) {

            	long num = arr[left] + arr[right] + arr[mid];
            	
            	if(Math.abs(num)<minA) {
            		resultA = arr[left];
            		resultB = arr[mid];
            		resultC = arr[right];
            		
            		minA = Math.abs(num);
            	}
            	
            	if(num<=0) mid++;
            	else right--;
        	}
        }
        
        System.out.println(resultA + " " + resultB + " " + resultC);
    }
}
