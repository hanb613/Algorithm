import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int tc, h, w, n;
	public static Info info;
	public static String oper;
	public static char[][] game;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int T=1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			game = new char[h][w];
			
			// 게임 맵 입력 받기
			String str;
			for(int i=0; i<h; i++) {
				str = br.readLine();
				for(int j=0; j<w; j++) {
					game[i][j] = str.charAt(j);
					if(game[i][j] == '^' || game[i][j] == 'v' || game[i][j] == '<' || game[i][j] == '>') { // 현재 전차 위치와 방향 담기
						info = new Info(i, j, game[i][j]);
					}
				}
			}
			
			// 사용자 입력 받기
			n = Integer.parseInt(br.readLine());
			oper=br.readLine(); 
			
			// 순서대로 사용자 입력 처리
			char nowOper;
			for(int i=0; i<n; i++) {
				nowOper = oper.charAt(i);
				
				if(nowOper=='U') { // Up
					info.c = '^';
					if(info.x-1>=0 && game[info.x-1][info.y] == '.') {
						game[info.x][info.y]='.';
						info.x-=1;
					} 
					game[info.x][info.y]=info.c;
					
				} else if(nowOper=='D') { // Down
					info.c = 'v';
					if(info.x+1<h && game[info.x+1][info.y] == '.') { // 이동할 수 있는 범위이고, 평지이면 이동 
						game[info.x][info.y]='.'; // 원래 위치 -> 평지로 변경
						info.x+=1; // 위치 이동
					} 
					game[info.x][info.y]=info.c; // 전차 방향 변경
					
				} else if(nowOper=='L') { // Left
					info.c = '<';
					if(info.y-1>=0 && game[info.x][info.y-1] == '.') {
						game[info.x][info.y]='.';
						info.y-=1;
					} 
					game[info.x][info.y]=info.c;
					
				} else if(nowOper=='R') { // Right
					info.c = '>';
					if(info.y+1<w && game[info.x][info.y+1] == '.') {
						game[info.x][info.y]='.';
						info.y+=1;
					}
					game[info.x][info.y]=info.c;
					
				} else if(nowOper=='S') { // Shoot
					if(info.c=='^') { // 현재 전차 방향이 ^ 이면 
						int shotX, shotY=info.y;
						if(info.x-1>=0) shotX=info.x-1;
						else shotX=0;
						
						while(shotX>=0) { // 벽에 충돌하거나 게임 맵 밖으로 나갈 때 까지 직진
							if(game[shotX][shotY]=='#') { // 강철로 만들어진 벽이면 break
								break;
							}
							if(game[shotX][shotY]=='*') { // 벽돌로 만들어진 벽이면, 평지로 만들고 break
								game[shotX][shotY]='.';
								break;
							}
							shotX--;
						}
					} else if(info.c == 'v') {
						int shotX, shotY=info.y;
						if(info.x+1<h) shotX=info.x+1;
						else shotX=h-1;
						
						while(shotX<h) {
							if(game[shotX][shotY]=='#') {
								break;
							}
							if(game[shotX][shotY]=='*') {
								game[shotX][shotY]='.';
								break;
							}
							shotX++;
						}
					} else if(info.c == '<') {
						int shotX=info.x, shotY;
						if(info.y-1>=0) shotY=info.y-1;
						else shotY=0;
						
						while(shotY>=0) {
							if(game[shotX][shotY]=='#') {
								break;
							}
							if(game[shotX][shotY]=='*') {
								game[shotX][shotY]='.';
								break;
							}
							shotY--;
						}
					} else if(info.c == '>') {
						int shotX=info.x, shotY;
						if(info.y+1<w) shotY=info.y+1;
						else shotY=w-1;
						
						while(shotY<w) {
							if(game[shotX][shotY]=='#') {
								break;
							}
							if(game[shotX][shotY]=='*') {
								game[shotX][shotY]='.';
								break;
							}
							shotY++;
						}
					}
				}
			}
			
			// 출력
			System.out.print(String.format("#%d ", T));
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(game[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static class Info{
		int x, y;
		char c;
		
		public Info(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}