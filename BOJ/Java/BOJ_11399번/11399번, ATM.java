import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n=Integer.parseInt(br.readLine());
   
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int sum=0;
        for(int i=0; i<n; i++) {
        	sum+=arr[i];
        	result+=sum;
        }
        
        System.out.println(result);
    }
}