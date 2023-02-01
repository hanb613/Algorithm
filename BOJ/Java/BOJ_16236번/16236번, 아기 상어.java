import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int result, size=2, cnt;
	static Pair now;
	static List<Pair> fish;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
				if(arr[i][j]==9) {
					now = new Pair(i, j);
					arr[i][j]=0;
				}
			}
		}
		
		while(true) {
			fish = new ArrayList<Pair>();
			
			boolean visited[][] = new boolean[n][n];
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(now.x, now.y, 0)); // 물고기를 먹었으므로 0으로 거리 갱신
			visited[now.x][now.y] = true;

			while(!q.isEmpty()) {
				Pair shark = q.remove();

				for(int i = 0; i < 4; i++) {
					int nx = shark.x + dx[i];
					int ny = shark.y + dy[i];

					if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) continue;
					
					if(arr[nx][ny]>0 && arr[nx][ny]<size) { // 나보다 크기가 작은 경우
						visited[nx][ny] = true;
						q.add(new Pair(nx, ny, shark.dist+1));
						fish.add(new Pair(nx, ny, shark.dist+1)); // 내가 먹을 수 있는 먹이 리스트에 삽입
					} 
					else if(arr[nx][ny] == 0 || arr[nx][ny] == size) { // 나랑 크기가 같은 물고기
						visited[nx][ny] = true;
						q.add(new Pair(nx, ny, shark.dist+1));
					}
				} 
			}
			
			if(fish.size() == 0) break; // 먹을 수 있는 물고기 X
			else { // 먹을 수 있는 물고기 O
				Pair eat = fish.get(0);
				for(int i = 1; i < fish.size(); i++){
					if(fish.get(i).dist < eat.dist) { // 거리가 제일 작은걸로
						eat = fish.get(i);
					} 
					else if(fish.get(i).dist == eat.dist) { // 거리가 같으면 왼쪽에 있는걸로
						if(fish.get(i).x < eat.x){
							eat = fish.get(i);
						}   
					}
				}

				cnt++;
				result += eat.dist;
				arr[eat.x][eat.y] = 0;

				if(cnt == size) { // 먹은 수 == 내 크기
					size++;
					cnt = 0;
				}

				now.x = eat.x;
				now.y = eat.y;
			}
		}
		
		System.out.println(result);
	}
	
	
	public static class Pair{
		int x, y, dist;
		
		Pair(){ }
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
		Pair(int x, int y, int dist){
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
	}
}
