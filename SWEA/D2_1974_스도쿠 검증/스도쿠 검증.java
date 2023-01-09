import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int T=1; T<=tc; T++){
            boolean ret = true;
            int[][] arr = new int[9][9];

            for(int i=0; i<9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<9; i++){
                boolean[] check_row = new boolean[9];
                boolean[] check_col = new boolean[9];
                for(int j=0; j<9; j++){
                    if(check_row[arr[i][j]-1] || check_col[arr[j][i]-1]) {
                        ret = false; break;
                    }
                    check_row[arr[i][j]-1] = true;
                    check_col[arr[j][i]-1] = true;
                }
            }

            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    boolean[] check = new boolean[9];
                    for(int k=i; k<i+3; k++) {
                        for(int w=j; w<j+3; w++){
                            if(check[arr[k][w]-1]) {
                                ret = false;  break;
                            }
                            check[arr[k][w]-1] = true;
                        }
                    }
                }
            }
            if(!ret) System.out.println("#"+T+" "+0);
            else System.out.println("#"+T+" "+1);

        }

    }
}