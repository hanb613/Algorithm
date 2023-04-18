import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * 1. 계단 배정 (PowerSet)
 * 2. 계단별 사람 리스트 만들기
 * 	  - 맨허튼 거리를 이용해서 계단 도착 시간 계산
 * 3. 사람 리스트를 도착 시간이 빠른순으로 정렬
 * 4. (시뮬) 시작 시간 : 첫 사람이 해당 계단에 도착시간 (time)
 * 5. 모든 사람에 대해 시간별 처리
 * 	  => 모든 사람이 이동 완료 할 때까지
 * 	  => 해당 사람의 도착시간이 time과 일치하면? 도착상태인 사람 (1분 대기처리)
 * 	  => 해당 사람이 도착상태인 사람 (내려가고 있는 사람 < 3) : 내려가는 상태인 사람 (내려가는 계단 수 카운팅 + 내려가고 있는 사람 수 증가)
 * 	  => 해당 사람이 내려가고 있는 사람
 * 			- [내려간 계단 수 == 계단 길이] : 이동 완료 사람 => 내려가고 있는 사람 수 감수, 완료 사람 수 증가
 * 			- [내려간 계단 수 < 계단 길이] : 계단 수 카운팅
 * -> Math.max(계단 A(time1), 계단 B(time2))
 * 
 * 
 * class Person implements Comparable<Person> {
 * 		r, c, arrivalTime, downCnt, status
 * 		arrivalTime 기준으로 정렬
 * }
 * 
 */

public class Solution {
	
	static int N, cnt, ans;
	static int[][] arr;
	static final int M=1, W=2, D=3, C=4; // 이동중, 대기, 내려가는중, 완료
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(in.readLine());
			pList = new ArrayList<Person>(); // 사람 리스트
			sList = new int[2][]; // 계단 리스트
			ans=Integer.MAX_VALUE;
			
			StringTokenizer st;
			for(int i=0, k=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if(c==1) pList.add(new Person(i, j));
					else if(c>1) sList[k++] = new int[] {i, j, c};
				}
			}
			
			cnt = pList.size();
			selected = new int[cnt]; // 선택한 계단 인덱스
			
			// 모든 사람에게 계단 배정
			divide(0);
			System.out.println(String.format("#%d %d", tc, ans));
		}
	}
	
	// power set
	static void divide(int index) {
		if(index == cnt) {
			int res = go();
			ans = Math.min(ans, res);
			
			return;
		}
		
		// 계단0 선택
		selected[index]=0;
		divide(index+1);
		
		// 계단1 선택
		selected[index]=1;		
		divide(index+1);		
		
	}
	
	// 선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리 후 소요된 시간 리턴
	static int go() {
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };
		
		for(int i=0; i<cnt; i++) {
			Person p = pList.get(i);
			p.init();
			int no = selected[i];
			p.arrivalTime = Math.abs(p.r-sList[no][0]) + Math.abs(p.c-sList[no][1]);
			list[no].add(p);
		}
		
		int timeA=0, timeB=0;
		if(list[0].size()>0) {
			timeA = processDown(list[0], sList[0][2]);
		}
		if(list[1].size()>0) {
			timeB = processDown(list[1], sList[1][2]);
		}
		
		return timeA>timeB?timeA:timeB;
	}
	
	static int processDown(ArrayList<Person> list, int height) {
		
		Collections.sort(list); // 계단 입구까지 도착시간이 빠른 순으로 정렬
		
		int time = list.get(0).arrivalTime; // 먼저 도착한 사람의 시간부터 흘러가게 함
		int size = list.size();
		int ingCnt=0, cCnt=0; // 내려가는 사람 수, 완료 사람 수
		Person p = null;
		
		while(true) {
			
			// 해당 시간에 모든 사람에 대해 처리
			for(int i=0; i<size; i++) {
				p =list.get(i);
				if(p.status == C) {
					continue;
				} else if(p.arrivalTime == time) {
					p.status = W;
				} else if(p.status == W && ingCnt<3) {
					p.status = D;
					p.downCnt = 1;
					ingCnt++;
				} else if(p.status == D) {
					if(p.downCnt == height) {
						p.status = C;
						ingCnt--;
						cCnt++;
					} else {
						p.downCnt++;
					}
				}
			} 
			
			if(cCnt==size) break;	
			time+=1;
		}
		
		return time;
	}
	
	static class Person implements Comparable<Person> {
		int r, c, arrivalTime, downCnt, status;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public void init() {
			arrivalTime = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
	}
}