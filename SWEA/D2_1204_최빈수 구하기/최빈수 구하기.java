import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int T = 1; T <= tc; T++) {
            int[] num = new int[101];
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                num[Integer.parseInt(st.nextToken())]++;
            }

            int max=0, result=0;
            for(int i=0; i<=100; i++){
                if (max <= num[i]) {
                    max = num[i];
                    result = i;
                }
            }

            System.out.println("#" + T + " " + result);
        }
    }
}