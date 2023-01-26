import java.io.*;
import java.util.*;

public class Main {
	static int n, m, virusCnt, wallCnt=3;
	static int total, result;
	static int[][] arr, newArr;
	static boolean[][] visit;
	
	static List<Pair> area;
	
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		area = new ArrayList<>();
		
		arr = new int[n][m];
		total = n*m;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 0) area.add(new Pair(i, j));
				else if(arr[i][j]==1) wallCnt++;
				else if(arr[i][j]==2) virusCnt++;
				
			}
		}
		
		int size = area.size();
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				for(int k=j+1; k<size; k++) {
					
					// 벽 3개 세우기
					arr[area.get(i).x][area.get(i).y] = 1;
					arr[area.get(j).x][area.get(j).y] = 1;
					arr[area.get(k).x][area.get(k).y] = 1;
				
					BFS();
					
					// 다시 되돌려놓기
					arr[area.get(i).x][area.get(i).y] = 0;
					arr[area.get(j).x][area.get(j).y] = 0;
					arr[area.get(k).x][area.get(k).y] = 0;
				}
			}
		}
		
		System.out.println(result);
	}

	
	public static void BFS() {
		Queue<Pair> virus = new LinkedList<>();
		
		int v = virusCnt; // 현재 바이러스 개수
		newArr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 2) {
					virus.add(new Pair(i, j));
				}
				newArr[i][j] = arr[i][j];
			}
		}
		
		while(!virus.isEmpty()) {
			Pair p = virus.remove();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny >= m) continue;
				
				if(newArr[nx][ny] == 0 && !visit[nx][ny]) {
					v++;
					visit[nx][ny]=true;
					virus.add(new Pair(nx, ny));
				}
			}
		}
		
		result = Math.max(result, total - v - wallCnt); // 전체 영역 - 바이러스 수 - 벽 개수
		return;
		
		
	}
	
	public static class Pair{
		int x;
		int y;
		
		Pair() { }
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
