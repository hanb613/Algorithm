import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int t;
	static int m, a, result;
	static ArrayList<Charge> arr;		
	static int[] da;
	static int[] db;
	static int[] dx= {0, 0, 1, 0, -1};
	static int[] dy= {0, -1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
		t=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

			result=0;
			arr=new ArrayList<>();
			da=new int[m+1];
			db=new int[m+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				da[i]=Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				db[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new Charge(
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken())));
			}
			
			Pos pa = new Pos(1, 1);
			Pos pb = new Pos(10, 10);

			for (int i = 0; i <= m; i++) {
				pa = new Pos(pa.y + dy[da[i]], pa.x + dx[da[i]]);
				pb = new Pos(pb.y + dy[db[i]], pb.x + dx[db[i]]);

				int max=0;
				for (int j = 0; j < arr.size(); j++) {
					for (int k = 0; k < arr.size(); k++) {
						int sum=0;
						int[] charge = new int[2];
						Charge A = arr.get(j); //a가 사용하는 충전소 
						Charge B = arr.get(k); //b가 사용하는 충전소 
						
						if(Math.abs(pa.x-A.x)+Math.abs(pa.y-A.y) <= A.c) { // 범위 내에 있을 때 
							charge[0]=A.p;
						}
						
						if(Math.abs(pb.x-B.x)+Math.abs(pb.y-B.y) <= B.c) { // 범위 내에 있을 때 
							charge[1]=B.p;
						}
						
						if(j != k) { // 다른 충전소 사용하면 그냥 더한다
							sum=charge[0]+charge[1];
						} else { // 같은 충전소
							sum=Math.max(charge[0], charge[1]); // max => 사용할 수 없으면 0
						}
						
						max = Math.max(max, sum);						
					}	
				}
				result+=max;
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static class Pos{
		int y, x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static class Charge{
		int x, y, c, p;

		public Charge(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}