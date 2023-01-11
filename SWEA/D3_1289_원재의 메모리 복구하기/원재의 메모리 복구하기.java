import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int T=1; T<=t; T++){
            String num = br.readLine();
            char before = '0';
            int result = 0;
            for(int i=0; i<num.length(); i++){
                if(before != num.charAt(i)){
                    result++;
                    before = num.charAt(i);
                }
            }
            System.out.println(String.format("#%d %d", T, result));
        }
    }
}