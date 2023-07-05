import java.util.*;
import java.io.*;

public class Main{

	static int n, count;
	static int[] num; 
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
        
        solve(n, 0);
		
        System.out.println(count);
	}
    
    public static void solve(int n, int idx) {
        if(n == idx) {
            count++; return;
        }
        
        for(int i=0; i<n; i++) {
            num[idx] = i;
            if(check(idx)) {
            	solve(n, idx+1);
            }
        }
    } 
    
    public static boolean check(int idx) {
        for(int i=0; i<idx; i++) {
            if(num[i] == num[idx]) return false; // 같은 행에 존재
            if(Math.abs(idx-i) == Math.abs(num[idx]-num[i])) return false; //대각선에 존재
        }
        
        return true;
    }
}