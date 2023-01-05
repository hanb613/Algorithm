import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static int calc(int[] x, int[] y){
        int ret=0;
        for(int i=0; i <= y.length - x.length; i++){
            int tmp=0;

            for(int j=0; j<x.length; j++){
                tmp += (x[j] * y[j+i]);
            }
            ret = Math.max(ret, tmp);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int T = 1; T <= tc; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[Integer.parseInt(st.nextToken())];
            int[] B = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<A.length; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<B.length; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            int result=0;
            if(A.length > B.length) result=calc(B, A);
            else result=calc(A, B);

            System.out.println("#" + T + " " + result);
        }
    }
}