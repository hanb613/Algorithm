import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end-o.end : this.start - o.start;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting[] m = new Meeting[count];
		
		for(int i=0; i<count; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(m);
		
		List<Meeting> result = new ArrayList<Meeting>();
		result.add(m[0]);
		
		for(int i=1; i<count; i++) {
			if(result.get(result.size()-1).end <= m[i].start) {
				result.add(m[i]);
			}
		}
		
		System.out.println(result.size());
	}
	
}