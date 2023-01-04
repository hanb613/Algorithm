import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int[][] arr = new int[101][101];
            int result = 0;

            int num = Integer.parseInt(br.readLine());
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans1=0, ans2=0;
            for(int i=0; i<100; i++){
                ans1 += arr[i][i];
                ans2 += arr[i][99-i];

                int ans3=0, ans4=0;
                for(int j=0; j<100; j++){
                    ans3 += arr[i][j];
                    ans4 += arr[j][i];
                }
                result = Math.max(result, ans3);
                result = Math.max(result, ans4);
            }
            result = Math.max(result, ans1);
            result = Math.max(result, ans2);

            System.out.println("#" + num + " " + result);
        }
    }
}