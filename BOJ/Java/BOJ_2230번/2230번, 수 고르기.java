import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n;
    static long result=Long.MAX_VALUE, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0, right = 0;

        while(right<n && left<=right){
            
            int diff = arr[right]-arr[left];

            if(diff>=m){
                left+=1;
                result = Math.min(result, diff);
            } else{
                right+=1;
            }

        }

        System.out.println(result);
    }
}