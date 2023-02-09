import java.io.*;
import java.util.*;

public class Main {
	static int s, p, count;
	static int[] check;
	static int[] arr;
	static char[] ch ;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		ch = (br.readLine()).toCharArray();
		
		check = new int[4];
		arr = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<p; i++) { // 'A','C','G','T' 저장
			add(ch[i]);
		}
		
		// 처음 부분 문자열 -> 비밀번호 가능한지 체크
		if(check[0]<=arr[0] && check[1]<=arr[1] && check[2]<=arr[2] && check[3]<=arr[3]) count++;
		
		// end가 문자열의 마지막 글자가 될 때까지
		for(int end=p; end<s; end++) { 
			int start = end-p;
			remove(ch[start]);
			add(ch[end]);
			if(check[0]<=arr[0] && check[1]<=arr[1] && check[2]<=arr[2] && check[3]<=arr[3]) count++;
		}
		
		System.out.println(count);
	}
	
	public static void add(char c) { 
		if(c=='A') arr[0]++;
		else if(c=='C') arr[1]++;
		else if(c=='G') arr[2]++;
		else if(c=='T') arr[3]++;
	}
	
	public static void remove(char c) {
		if(c=='A') arr[0]--;
		else if(c=='C') arr[1]--;
		else if(c=='G') arr[2]--;
		else if(c=='T') arr[3]--;
	}
}