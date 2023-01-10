import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int GCD(int a, int b) {
        while(b > 0) {
            int temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }

    static int LCM(int a, int b) {
        return (a*b)/GCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int TC=1; TC<=tc; TC++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inp_S = st.nextToken();
            String inp_T = st.nextToken();

            String S = inp_S;
            String T = inp_T;

            if(S.length() != T.length()) {
                int len = LCM(S.length(), T.length());

                while(S.length() != len) {
                    S += inp_S;
                }

                while(T.length() != len) {
                    T += inp_T;
                }
            }

            if(S.equals(T)) System.out.println("#"+TC+" "+"yes");
            else System.out.println("#"+TC+" "+"no");
        }
    }
}