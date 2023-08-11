import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int r, c, q, r1, r2, c1, c2;
    static int[][] sumArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        sumArr = new int[r+1][c+1];

        int num=0;
        for(int i=1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=c; j++){
                num = Integer.parseInt(st.nextToken());
                sumArr[i][j]+=sumArr[i][j-1]+sumArr[i-1][j]-sumArr[i-1][j-1] + num;
            }
        }

        for(int t=0; t<q; t++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            int sum=sumArr[r2][c2]-sumArr[r1-1][c2]-sumArr[r2][c1-1]+sumArr[r1-1][c1-1];

            sb.append(sum/((c2-c1+1)*(r2-r1+1))).append("\n");
        }

        System.out.println(sb.toString());
    }
}