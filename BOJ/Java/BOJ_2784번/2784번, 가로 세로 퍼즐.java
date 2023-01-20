import java.io.*;
import java.util.*;

public class Main {
	static String[] str, result;
	static boolean[] visit, visitTmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = new String[6];
		
		for(int i=0; i<6; i++) {
			str[i] = br.readLine();
		}
		
		result = new String[3];
		visit = new boolean[6];
		
		Solution(0);
		
		System.out.println(0);
	}
	
	public static void check() {
		int cnt=0;
		visitTmp = new boolean[6];
		
		for(int i=0; i<3; i++) {
			String strR="";
			String strC="";
			
			for(int j=0; j<3; j++) {
				strR += result[i].charAt(j);
				strC += result[j].charAt(i);
			}
			
			for(int t=0; t<6; t++) {
				if(!visitTmp[t] && str[t].equals(strR)) {
					visitTmp[t]=true; cnt++; 
					break;
				}
			}

			for(int t=0; t<6; t++) {
				if(!visitTmp[t] && str[t].equals(strC)){
					visitTmp[t]=true; cnt++;
					 break;
				}
			}
		}
		
		if(cnt==6) {
			for(int i=0; i<3; i++) {
				System.out.println(result[i]);
			}
			
			System.exit(0);
		}
	}
	
	public static void Solution(int k) {
		if(k==3) {
			check();
			return;
		}
		
		for(int i=0; i<6; i++) {
			if(!visit[i%6]) {
				visit[i%6]= true;
				result[k] = str[i%6];
				Solution(k+1);
				visit[i%6]= false;
			}	
		}
		
	}
}

