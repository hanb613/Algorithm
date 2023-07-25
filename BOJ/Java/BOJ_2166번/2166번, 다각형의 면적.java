import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static long a, b;
    static long[] x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        x = new long[n+1];
        y = new long[n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[n] = x[0];
        y[n] = y[0];

        for(int i=0; i<n; i++){
            a+=(x[i] * y[i+1]);
            b+=(x[i+1] * y[i]);
        }

        System.out.println(String.format("%.1f", Math.abs(a-b) / 2.0));
    }
}