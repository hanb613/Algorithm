import java.io.*;
import java.util.*;

public class Solution{

	static int n, tc, result, size;
	static boolean[] visited;
	static Stair[] stairs;
	static Queue<Person>[] q;
	static List<Person> persons;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		
		for(int t=1 ; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			persons = new ArrayList<>();
			q = new LinkedList[2];
			q[0] = new LinkedList<>();
			q[1] = new LinkedList<>();
			stairs = new Stair[2];
			result = Integer.MAX_VALUE;
			
			int num, idx=0;
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					num = Integer.parseInt(st.nextToken()); 
					
					if(num == 1) {
						persons.add(new Person(i, j));
					} else if(num>=2) {
						stairs[idx++] = new Stair(i, j, num);
					}
				}
			}
			
			size = persons.size();
			select(0);
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void select(int idx) {
		if(idx == size) {
			result = Math.min(result, simulation());
			return;
		}
		
		// 첫번째 계단
		persons.get(idx).stair=0;
		persons.get(idx).calArriveTime(); // 계단 입구까지 이동 시간
		select(idx+1);
		
		// 두번째 계단
		persons.get(idx).stair=1;
		persons.get(idx).calArriveTime();
		select(idx+1);
	}

	private static int simulation() {
		int cnt=0, time=1;
		visited = new boolean[size];
		
		while(true) {
			for(Queue<Person> q : q) {
				int size2=q.size();
				for(int i=0; i<size2; i++) {
					Person p = q.poll();
					Stair s = stairs[p.stair];
					
					if(p.stairTime+s.k <= time) continue;
					
					q.offer(p);
				}
			}
			
			if(q[0].isEmpty() && q[1].isEmpty() && cnt==size) { // 종료 조건
				return time;
			}
			
			for(int i=0; i<size; i++) {
				if(visited[i]) continue;
				
				Person p = persons.get(i);
				Queue<Person> q2 = q[p.stair];
				
				if(q2.size()<3 && p.arriveTime+1<=time) { 
					p.stairTime = time;
					visited[i] = true;
					q2.offer(p);
					cnt++;
				}
			}
			time++;
		}
	}
	
	private static class Stair {
		int r, c, k;
		
		public Stair(int r, int c, int k){
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	private static class Person {
		int r, c, stair;
		int arriveTime, stairTime;
		
		public Person(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		private void calArriveTime() {
			this.arriveTime = Math.abs(r-stairs[stair].r) + Math.abs(c-stairs[stair].c);
		}
	}
}