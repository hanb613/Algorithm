import java.io.*;
import java.util.*;

public class Main {

	static int g, left, right, result;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		g = Integer.parseInt(br.readLine());
		
		left = right =1;
		
		while(true) {
			long diff = (long)(Math.pow(right, 2)) - (long)(Math.pow(left, 2));
			
			if(right-left==1 && diff > g) break;
			
			if(diff<g) right++;
			else left++;
			
			if(diff==g) {
				System.out.println(right);
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println(-1);
		}
		
	}
}