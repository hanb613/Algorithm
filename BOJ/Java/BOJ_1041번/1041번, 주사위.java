import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static long result;
	static int[] arr, min;
	static long[] total;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[6];
		min = new int[3];
		total = new long[3];
		
		st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        min[0] = Math.min(arr[0], arr[5]);
        min[1] = Math.min(arr[1], arr[4]);
        min[2] = Math.min(arr[2], arr[3]);

        Arrays.sort(min);
        Arrays.sort(arr);

        total[0] = 4L; // 3개의 면
        total[1] = 8L*(n-2)+4; // 2개의 면
        total[2] = 5L*(n-2)*(n-2)+4L*(n-2); // 1개의 면
	
        if(n == 1) {
            result = arr[0]+arr[1]+arr[2]+arr[3]+arr[4];
        } else {
        	result = total[0]*(min[0]+min[1]+min[2]) +
            		 total[1]*(min[0]+min[1]) +
            		 total[2]*min[0];
        }
        
        System.out.println(result);
	}
}