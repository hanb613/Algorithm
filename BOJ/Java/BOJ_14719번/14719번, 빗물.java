import java.io.*;
import java.util.*;

public class Main {
	
	static int h, w, result;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		height = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<w-1; i++) {
			int left=0;
			int right=0;
			
			// 현대 인덱스 기준으로, 
			for(int j=0; j<i; j++) { // 왼쪽에서 가장 높은 거
				left = Math.max(left, height[j]);
			}
			
			for(int j=i+1; j<w; j++) { // 오픈쪽에서 가장 높은 거
				right = Math.max(right, height[j]);
			}
			
			if(height[i] < left && height[i] < right) {
				int minH = Math.min(left, right); // 둘 중에 낮은 거 - 현재 높이 = 고인 빗물 높이
				result+=(minH-height[i]);
			}
		}
		
		System.out.println(result);
		
	}
}