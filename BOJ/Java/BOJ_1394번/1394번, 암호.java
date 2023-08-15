import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int inpLength, retLength;
    static long result;
    static String inp, ret;
    static long[] arr;
    static Map<Character, Integer> map;

    static final int MOD = 900528;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inp = br.readLine();
        ret = br.readLine();
        inpLength = inp.length();
        retLength = ret.length();

        map = new HashMap<>();
        arr = new long[1000001];

        for(int i=0; i<inpLength; i++){
            map.put(inp.charAt(i), i+1);
        }

        arr[0] = 1;
        for(int i=1; i<retLength; i++){
            arr[i] = (arr[i-1] * (inpLength%MOD))%MOD;
        }

        for(int i=0; i<retLength; i++){
            result+=(map.get(ret.charAt(i)) * arr[retLength-1-i])%MOD;
        }

        System.out.println(result%MOD);
    }
}