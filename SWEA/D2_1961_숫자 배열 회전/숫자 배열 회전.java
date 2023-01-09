import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] arr;

    public static int[][] rotation(int[][] arr){
        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[i][j] = arr[n-j-1][i];
            }
        }

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int T=1; T<=tc; T++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] result_90 = rotation(arr);
            int[][] result_180 = rotation(result_90);
            int[][] result_270 = rotation(result_180);

            System.out.println("#" + T);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(result_90[i][j]);
                }
                System.out.print(" ");

                for(int j=0; j<n; j++){
                    System.out.print(result_180[i][j]);
                }
                System.out.print(" ");

                for(int j=0; j<n; j++){
                    System.out.print(result_270[i][j]);
                }
                System.out.println(" ");
            }
        }

    }
}