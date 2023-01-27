import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int n, k, l;

	static Pair[] dir;
	static Pair tail;
	static List<Pair> visited, apple;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		apple = new ArrayList<>();
		visited = new ArrayList<>();
		
		int x, y;
		String c;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
				
			apple.add(new Pair(x, y));
		}
		
		l = Integer.parseInt(br.readLine());
		dir = new Pair[l];
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			c = st.nextToken();
				
			dir[i] = new Pair(x, c);
		}
		
		// 북 : 0, 동 : 1, 남: 2, 서: 3
		visited.add(new Pair(1, 1));
		tail = new Pair(1, 1); // 꼬리 위치
		int nx=1, ny=1, d=1; // 현재 x, y, 방향
		int total=0; // 총 시간
		int idx =0; // 방향 변환 정보 인덱스
		
		while(true) {
			total++;
			
			if(idx < l && dir[idx].sec==total-1) { // 방향 변환 정보 체크
				if(dir[idx].d.equals("L")) d = (d+3)%4; // 왼쪽으로 방향 회전
				else d = (d+1)%4; // 오른쪽으로 방향 회전
				
				idx++;
			}
			
			if(d==0) nx-=1;
			else if(d==1) ny+=1;
			else if(d==2)nx+=1;
			else if(d==3) ny-=1;
			
			if(check(nx, ny) == 1) break;
			
			visited.add(new Pair(nx, ny)); // 현재 위치 visited에 넣기
			if(isApple(nx, ny)==0) { // 사과가 없으면 꼬리 위치 갱신
				tail.x=visited.get(1).x;
				tail.y=visited.get(1).y;
				visited.remove(0);
			}
		}
		
		System.out.println(total);
	}

	public static int check(int x, int y) {
		if(x<1 || y<1 || x>n || y>n) return 1; // 벽 부딪
		
		for(int i=0; i<visited.size(); i++) { // 자기 자신이랑 부딪 
			if(x==visited.get(i).x && y== visited.get(i).y) return 1;
		}
		
		return 0;
	}
	
	public static int isApple(int x, int y) {
		for(int i=0; i<apple.size(); i++) {
			if(apple.get(i).x == x && apple.get(i).y == y) {
				apple.remove(i);
				
				return 1;
			}
		}
		
		return 0;
	}
	
	public static class Pair{
		int x, y, sec;
		String d;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Pair(int sec, String d){
			this.sec = sec;
			this.d = d;
		}
	}
}
