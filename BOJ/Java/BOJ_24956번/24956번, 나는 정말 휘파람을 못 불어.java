import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static String str;
    static long w, h, e, result;
    
    static final int MOD = 1000000007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        
        for(int i=0; i<str.length(); i++) {
        	if(str.charAt(i)=='W') {
        		w++;
        	} else if(str.charAt(i)=='H') {
        		h+=w;
        	} else if(str.charAt(i)=='E') {
        		result=(result*2) % MOD; // whee, wheee, + e => 가짓수 2배가 된다.
        		result+=e;
        		e+=h;
        	}
        }
        
        System.out.println(result%MOD);
    }
}