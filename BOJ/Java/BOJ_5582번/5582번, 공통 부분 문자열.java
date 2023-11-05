import java.util.*;
import java.io.*;

public class Main {

	static String str1, str2;
	static int result, len1, len2;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		str1 = br.readLine();
		str2 = br.readLine();
		
		arr = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1]+1;
					result = Math.max(result, arr[i][j]);
				}
			}
		}
		
		System.out.println(result);
	}
}