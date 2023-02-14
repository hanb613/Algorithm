import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int tc, n, m;
    public static long result;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());
        for (int T=1; T<=tc; T++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = -1;
            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    int sum = arr[i] + arr[j];
                    if(sum<=m)     result = Math.max(result, sum);
                }
            }

            System.out.println(String.format("#%d %d", T, result));
        }
    }
}