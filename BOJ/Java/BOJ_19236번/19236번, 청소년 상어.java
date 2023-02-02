import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result;
	static int[][] fishNum;
	static Pair[] arr;
	
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		fishNum = new int[4][4];
		arr = new Pair[17];

		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken())-1;
				fishNum[i][j] = a; //물고기 번호 저장
				arr[a] = new Pair(a, i, j, b, false); // 물고기 번호, x, y, 방향, 죽음
			}
		}
		
		int sd = arr[fishNum[0][0]].dir;
		int eat=fishNum[0][0]; // 상어가 먹은 물고기 번호
		arr[fishNum[0][0]].dead = true; // 죽음
		fishNum[0][0] = -1; // 상어 위치
		
		Solution(0, 0, sd, eat);
		
		System.out.println(result);
	}
	
	public static void copyArr(int[][]A, int[][] B) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				A[i][j]=B[i][j];
			}
		}
	}
	
	public static void Solution(int x, int y, int d, int eatNum) {
		result = Math.max(result, eatNum);
		
		int[][] newArr = new int[4][4];
		Pair[] newPair = new Pair[17];
		
		copyArr(newArr, fishNum);
		for(int i=1; i<=16; i++) {
			newPair[i]=new Pair(arr[i].num, arr[i].x, arr[i].y, arr[i].dir, arr[i].dead);
		}
		
		// 물고기 이동
		fishMove(); 
		
		// 상어 이동
		for(int i = 1; i < 4; i++) { // 1~3칸 이동 가능
			int nx = x+(dx[d]*i);
			int ny = y+(dy[d]*i);

			if(nx<0 || ny<0 || nx>=4 || ny>=4 || fishNum[nx][ny]==0) continue; // 이동 X
			
			int eatFish = fishNum[nx][ny];
			int nd = arr[eatFish].dir;
			arr[eatFish].dead = true;
			fishNum[x][y] = 0;
			fishNum[nx][ny] = -1;

			Solution(nx, ny, nd, eatNum+eatFish);

			arr[eatFish].dead = false;
			fishNum[x][y] = -1;
			fishNum[nx][ny] = eatFish;
		}
		
		copyArr(fishNum, newArr);
		for(int i=1; i<=16; i++) {
			arr[i]=new Pair(newPair[i].num, newPair[i].x, newPair[i].y, newPair[i].dir, newPair[i].dead);
		}
	}
	
	public static void fishMove() {
		
		for(int i=1; i<=16; i++) {
			if(arr[i].dead) continue;
			
			int d=arr[i].dir;
			
			for(int T=0; T<8; T++) {
				int nx=arr[i].x+dx[d];
				int ny=arr[i].y+dy[d];
				arr[i].dir = d; 
				d=(d+1)%8;
				
				if(nx<0 || ny<0 || nx>=4 || ny>=4 || fishNum[nx][ny]==-1) continue; // 이동 못함
				
				if(fishNum[nx][ny] == 0) { // 물고기 없을 떄
					fishNum[arr[i].x][arr[i].y] = 0;
					arr[i].x = nx;
					arr[i].y = ny;
					fishNum[nx][ny] = i; 
				} else { // 물고기가 있을 경우 
					int tmp = arr[fishNum[nx][ny]].num;
					arr[tmp].x = arr[i].x;
					arr[tmp].y = arr[i].y;
					fishNum[arr[tmp].x][arr[tmp].y] = tmp;

					//현재 물고기 위치 변경 
					arr[i].x = nx;
					arr[i].y = ny;
					fishNum[nx][ny] = i;
				}
				break;
			}
		}
	}
	
	public static class Pair{
		int x, y, num, dir;
		boolean dead;
		
		Pair(int num, int x, int y, int dir, boolean dead){
			this.num=num;
			this.x=x;
			this.y=y;
			this.dir=dir;
			this.dead=dead;
		}		
	}
}