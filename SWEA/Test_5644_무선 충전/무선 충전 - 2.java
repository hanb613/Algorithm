import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, m, a, result;
	static ArrayList<Info> arr;
	static int[] A, B;
	
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            
            result=0;
			arr=new ArrayList<>();
			A=new int[m+1];
			B=new int[m+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new Info(
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken())));
			}
			
			Info pa = new Info(1,1);
			Info pb = new Info(10,10);
			
			for(int i=0; i<=m; i++) {
				pa = new Info(pa.x+dx[A[i]], pa.y+dy[A[i]]);
				pb = new Info(pb.x+dx[B[i]], pb.y+dy[B[i]]);
				
				int max=0;
				for(int j=0; j<arr.size(); j++) {
					for(int k=0; k<arr.size(); k++) {
						int sum=0;
						int[] charge = new int[2];
						Info a = arr.get(j);
						Info b = arr.get(k);
						
						if(Math.abs(pa.x-a.x) + Math.abs(pa.y-a.y) <= a.c) {
							charge[0]=a.p;
						}
						
						if(Math.abs(pb.x-b.x) + Math.abs(pb.y-b.y) <= b.c) {
							charge[1]=b.p;
						}
						
						if(j!=k) sum = charge[0]+charge[1];
						else sum = Math.max(charge[0], charge[1]);
						
						max = Math.max(max, sum);
					}
				}
				result += max;
			}
			
			System.out.println("#"+T+" "+result);
		}
    }
	
	private static class Info{
		int x, y, c, p;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Info(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}
