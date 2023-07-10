import java.util.*;
import java.io.*;

public class Main{
	
	static int n, c, result;
	static int cnt, start;
	static int[] distance;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		distance = new int[n];
		for(int i=0; i<n; i++) {
			distance[i] = Integer.parseInt(br.readLine());	
		}
		
		Arrays.sort(distance);
		
		int left = 1; // 두 집간의 최소 간격 거리
		int right = distance[n-1] - distance[0]; // 최대 간격 거리
		
		while(left <= right) {
			int mid = (left+right)/2;
			cnt=1; start = 0;
			
			for(int i=0; i<n; i++) {
				int dis = distance[i]-distance[start]; // 거리차이 계산
				
				if(dis>=mid) { // 설치 가능하면 => 인덱스 생긴 + 공유기 개수 카운트
					start = i;
					cnt++;
				}
			}
			
			if(cnt>=c) {
				left = mid+1;
				result = Math.max(result, mid);
			} else {
				right = mid-1;
			}
		}
		
		System.out.println(result);
	}
}