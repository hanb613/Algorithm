import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, tc;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		tc  = Integer.parseInt(br.readLine()); 
		
		for(int i=0; i<n; i++) {
			if(tc<=0) break;
			
			int max = 0, maxIdx = 0;
			for(int j=i; j<n; j++) {
				if(j>tc+i) break;
				
				if(max<=list.get(j)) {
					max = list.get(j);
					maxIdx = j;
				}
			}
			
			// 현재 위치에 최대값을 저장
			list.remove(maxIdx);
			list.add(i, max);
			
			tc-=(maxIdx-i); // (최대값 idx - 현재 위치 idx) = 교환한 횟수
		}
		
		for(int i : list) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
}