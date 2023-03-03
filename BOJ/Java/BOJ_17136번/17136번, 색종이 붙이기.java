import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] paper = {0,5,5,5,5,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[10][10];
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0, 0);
		
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void DFS(int x, int y, int cnt) {
		if(x>=9 && y>9) { // 맨 끝점에 도달
			result = Math.min(result, cnt);
			return;
		}
		
		if(result<=cnt) { // cnt가 더 크면 더 이상 탐색할 필요  X
			return;
		}
		
		if(y>9) { // 아래줄로 이동
			DFS(x+1, 0, cnt);
			return;
		}
		
		if(arr[x][y]==1) { // 색종이 붙일 수 있으면
			for(int i=5; i>=1; i--) {
				if(paper[i]>0 && isAttach(x, y, i)) {
					attach(x, y, i, 0); // 색종이 붙임
					paper[i]--;
					DFS(x, y+1, cnt+1);
					attach(x, y, i, 1); // 색종이 떼기
					paper[i]++;
				} 
			}
		} else { // 색종이 붙일 수 없으면 옆으로 이동
			DFS(x, y+1, cnt);
		}
	}
	
	private static void attach(int x, int y, int size, int state) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
                arr[i][j] = state;
            }
        }
	}
	
	private static boolean isAttach(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(i>=10 || j>=10) return false;
				if(arr[i][j]!=1) return false;
			}
		}
		return true;
	}
}