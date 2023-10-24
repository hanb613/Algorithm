import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static ArrayList<Info> star;
	static HashSet<Info> total, newStar;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		star = new ArrayList<>();
		total = new HashSet<>();
		newStar = new HashSet<>();
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			star.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			total.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(Info totalStar : total) {
			int x = totalStar.getX() - star.get(0).x;
			int y = totalStar.getY() - star.get(0).y;
			
			newStar.clear();
			
			for(int j=0; j<n; j++) {
				int nx = x + star.get(j).x;
				int ny = y + star.get(j).y;
				
				newStar.add(new Info(nx, ny));
			}
			
			if(total.containsAll(newStar)) {
				System.out.println(x + " " + y);
				break;
			}
		}
	}
	
	private static class Info{
		int x, y;
		
		public Info(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof Info) {
				Info i = (Info)o;
				return this.hashCode()==i.hashCode();
			}

			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.x, this.y);
		}
	}
}