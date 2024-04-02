import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, total;
	static int[] arr;
	static ArrayList<Info> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		total = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		arr = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<total; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(arr[num]>0) { // 이미 추천 받음
				for(Info j : list) {
					if(j.num == num) {
						j.cnt+=1;
						break;
					}
				}
				arr[num]++; // 추천 + 1
			} else {
				if(list.size()==n) { // 비어있는 사진이 없는 경우
					
					Collections.sort(list); // 우선순위별로 정렬
					
					arr[list.get(0).num]=0; // 추천 횟수 0
					list.remove(0);
				} 

				arr[num]=1;
				list.add(new Info(num, 1, i));
			}
		}
		
		for(int i=0; i<101; i++) {
			if(arr[i]!=0) {
				sb.append(i).append(" ");				
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static class Info implements Comparable<Info> {
		
		int num, cnt, time;
		
		public Info(int num, int cnt, int time) {
			this.num = num;
			this.cnt = cnt;
			this.time = time;
		}
		
		@Override
		public int compareTo(Info o) {
			if(o.cnt == this.cnt) {
				return this.time-o.time;
			}
			
			return this.cnt-o.cnt;
		}
		
	}
	
}