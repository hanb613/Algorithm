import java.io.*;
import java.util.*;

public class Solution {
		
	private static int n, m, k;
	private static ArrayList<Data> data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			data = new ArrayList<Data>();
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				data.add(new Data(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			
			for(int i=0; i<m; i++) {
				int size=data.size(); 
				for(int j=size-1; j>=0; j--) { // 지웠을 때 인덱스 변경 -> 끝에서부터 움직이기
					solve(j);
				}
				sumGroup(); // 모두 이동한 후, 같은 셀의 군집 합침
			}
			
			
			int result=0;
			for(int i=0; i<data.size(); i++) {
				result+=data.get(i).cnt;
			}
			System.out.println("#"+T+" "+result);
		}
	}
	
	private static void sumGroup() {
		Collections.sort(data);
		
		for(int i=0; i<data.size()-1; i++) {
			for(int j=i+1; j<data.size(); j++) {
				if((data.get(i).x == data.get(j).x) && (data.get(i).y == data.get(j).y)) {
					data.get(i).cnt+=data.get(j).cnt;
					data.remove(j);
					j--;
				}
			}
		}
	}
	
	private static void solve(int k) {
		switch(data.get(k).dir) {
			case 1:
				data.get(k).x-=1;
				if(data.get(k).x == 0) {
					data.get(k).cnt/=2;
					if(data.get(k).cnt==0) {
						data.remove(k);
						return;
					}
					data.get(k).dir=2; // 상 -> 하
				}
				break;
			case 2:
				data.get(k).x+=1;
				if(data.get(k).x == n-1) {
					data.get(k).cnt/=2;
					if(data.get(k).cnt==0) {
						data.remove(k);
						return;
					}
					data.get(k).dir=1; // 하 -> 상
				}
				break;
			case 3:
				data.get(k).y-=1;
				if(data.get(k).y == 0) {
					data.get(k).cnt/=2;
					if(data.get(k).cnt==0) {
						data.remove(k);
						return;
					}
					data.get(k).dir=4; // 좌 -> 우
				}
				break;
			case 4:
				data.get(k).y+=1;
				if(data.get(k).y == n-1) {
					data.get(k).cnt/=2;
					if(data.get(k).cnt==0) {
						data.remove(k);
						return;
					}
					data.get(k).dir=3; // 우 -> 좌
				}
				break;
		}
	}
	
	private static class Data implements Comparable<Data> {
		int x, y, cnt, dir;
		public Data(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Data o) {
			if(this.x==o.x) {
				if(this.y==o.y) {
					return o.cnt-this.cnt; // 군집 수 내림차순으로
				}
				return this.y-o.y;
			}
			return this.x-o.x;
		}
	}
}

