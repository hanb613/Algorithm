import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static long[] arr;
    static long m, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new long[n];

        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long left=0, right=arr[0] * m; // arr[n-1]*m = 오버플로우 

        while(left<=right){
            long mid=(left+right)/2;

            long sum=0;
            for(int i=0; i<n; i++){
                sum+=(mid/arr[i]);
            }

            if(m<=sum){
                result = mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }

        System.out.println(result);
    }
}