import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9][9];
		
		String inp="";
		for(int i=0; i<9; i++) {
			inp=br.readLine();
			for(int j=0; j<9; j++) {
				arr[i][j]=inp.charAt(j)-'0';
			}
		}
		
		solve(0, 0);
		
//		for(int i=0; i<9; i++) {
//			for(int j=0; j<9; j++) {
//				System.out.print(result[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	private static void solve(int x, int y) {
		if(x==9) { // 전부 채웠다면, 출력 후 종료
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		} else if(y==9) { // 열 다 채웠다면, 현재 행+1으로
			solve(x+1, 0);
			return;
		}
		
		if(arr[x][y] == 0) {
			for(int i=1; i<10; i++) { // 1부터 9까지 검사
				if(check(i, x, y)) { // 행, 열, 3*3에 해당 숫자가 없다면
					arr[x][y] = i;
					solve(x, y+1); // 다음 열로
					arr[x][y] = 0;
				}
			}
			return;
		}
		
		// 숫자가 있으면 다음 열로 
		solve(x, y+1);
	}
	
	private static boolean check(int num, int x, int y) {
		for(int i=0; i<9; i++) {
			if(arr[i][y]==num) return false; // 행 체크
			if(arr[x][i]==num) return false; // 열 체크
		}
		
		// 해당 좌표에 대한 3*3 사각형
		int nx=(x/3)*3;
		int ny=(y/3)*3;
		for(int i=nx; i<nx+3; i++) {
			for(int j=ny; j<ny+3; j++) {
				if(arr[i][j]==num) return false;
			}
		}
		
		return true;
	}
}