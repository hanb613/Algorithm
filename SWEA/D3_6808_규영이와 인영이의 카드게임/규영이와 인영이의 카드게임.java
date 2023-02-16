import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, result;
	static int[] ky, iy, num;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			result=0;
			st = new StringTokenizer(br.readLine());
			ky = new int[9];
			iy = new int[9];
			num = new int[9];
			visit = new boolean[9];
			
			for(int i=0; i<9; i++) {
				ky[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx=0;
			for(int i=1; i<=18; i++) {
				int check=0;
				for(int j=0; j<9; j++) {
					if(ky[j]==i) { check=1; break;}
				}
				if(check==0) iy[idx++]=i;
			}
			
			Solution(0);
			
			System.out.println(String.format("#%d %d %d", t, result, 362880-result));
		}
	}
	
	private static void Solution(int k) {
		if(k==9) {
			int kySum=0;
			int iySum=0;
			for(int i=0; i<9; i++) {
				if(ky[i]>num[i]) kySum +=ky[i]+num[i];
				else iySum+=ky[i]+num[i];
			}
			if(kySum > iySum) result++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visit[i]) {
				visit[i]=true;
				num[k]=iy[i];
				Solution(k+1);
				visit[i]=false;
			}
		}
	}
}
