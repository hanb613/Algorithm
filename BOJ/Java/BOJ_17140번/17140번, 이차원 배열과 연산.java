import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, k, time, result;
	static int[][] arr;
	static ArrayList<ArrayList<Info>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		arr = new int[3][3];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		while(time!=101) {
			// 답이 범위에 없어도 연산에 따라 답이 나올 수 있음 (tc 6번)
			if(r<=arr.length && c<=arr[0].length && arr[r-1][c-1]==k) {
				System.out.println(time);	
				System.exit(0);
			}
			
			int x = arr.length;
			int y = arr[0].length;

			list = new ArrayList<>();
			
			solve(x, y);
			
			time++;
		}
		
		System.out.println(-1);
	}
	
	private static void solve(int x, int y) {
		int maxLength=0;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		if(x>=y) { // R연산
			for(int i=0; i<x; i++) {
				map.clear();
				for(int j=0; j<y; j++) {
					if(arr[i][j]!=0) { // 0은 무시 
						if(map.containsKey(arr[i][j])) { // 횟수를 셌다면, 횟수 갱신
							map.replace(arr[i][j], map.get(arr[i][j])+1); 
						} else { // 카운트 한 숫자가 아니면 추가
							map.put(arr[i][j], 1);
						}
					}
				}
				
				// 값 넣기
				ArrayList tmp = new ArrayList<Info>();
				map.forEach((k,v)-> tmp.add(new Info(k, v))); // hashmap -> list
				list.add(i, tmp);
				maxLength=Math.max(maxLength, tmp.size()); // 가장 큰 행 갱신
				Collections.sort(list.get(i)); // 기준에 맞게 정렬
			}
			
			int size=maxLength*2;
			if(size>100) {
				size=100;
			}
			
			arr = new int[x][size];
			
			for(int i=0; i<arr.length; i++) {
				int idx=0;
				for(int j=0; j<list.get(i).size(); j++) {
					arr[i][idx++] = list.get(i).get(j).num;
					arr[i][idx++] = list.get(i).get(j).cnt;
				}
			}
		} else if(x<y) { // C연산
			for(int j=0; j<y; j++) {
				map.clear();
				for(int i=0; i<x; i++) {
					if(arr[i][j]!=0) { // 0은 무시 
						if(map.containsKey(arr[i][j])) { 
							map.replace(arr[i][j], map.get(arr[i][j])+1);
						} else {
							map.put(arr[i][j], 1);
						}
					}
				}
				
				// 값 넣기
				ArrayList tmp = new ArrayList<Info>();
				map.forEach((k,v)-> tmp.add(new Info(k, v)));
				list.add(j, tmp);
				maxLength=Math.max(maxLength, tmp.size()); // 가장 큰 열 갱신
				Collections.sort(list.get(j));
			}
			
			int size=maxLength*2;
			if(size>100) {
				size=100;
			}
			
			arr = new int[size][y];
			for(int i=0; i<y; i++) {
				int idx=0;
				for(int j=0; j<list.get(i).size(); j++) {
					arr[idx++][i] = list.get(i).get(j).num;
					arr[idx++][i] = list.get(i).get(j).cnt;
				}
			}
		}
	}
	
	private static class Info implements Comparable<Info> {
		int num, cnt;

		public Info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			if(this.cnt==o.cnt) {
				return this.num-o.num;
			}
			return this.cnt-o.cnt;
		}
	}
}
