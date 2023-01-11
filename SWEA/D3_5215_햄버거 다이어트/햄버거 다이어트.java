import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, l, result;
    static int[] t, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int T=1; T<=tc; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            t = new int[n];
            k = new int[n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                k[i] = Integer.parseInt(st.nextToken());
            }

            result =0;
            combination(0, 0, 0);

            System.out.println(String.format("#%d %d", T, result));
        }
    }

    public static void combination(int cnt, int score, int kcal){
        if(kcal > l) return;
        if(cnt == n){
            result = Math.max(result, score);
            return;
        }

        combination(cnt+1, score+t[cnt], kcal+k[cnt]);
        combination(cnt+1, score, kcal);

    }
}