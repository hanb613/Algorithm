import java.io.*;
import java.util.*;

public class Main {
	
	static int n, result;
	static char[][] arr;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j); 
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Solution(i, j);
			}
		}
		
		System.out.println(result);
	}
	
	public static void Solution(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue; // 범위 벗어나면 아래 코드 실행 X
			
			// 사탕 교환
			char tmp = arr[x][y];
			arr[x][y] = arr[nx][ny];
			arr[nx][ny] = tmp;
			
			// 원래 줄에서 가로 비교
			int resultR =0;
			for(int k=0; k<n; k++) {
				if(arr[x][y] != arr[k][y]) {  // 내꺼랑 다른거 나왔을 떄 초기화
					resultR =0;
				}
				else {  // 내꺼랑 똑같으면 ++
					resultR++;
				}
				result = Math.max(resultR, result);
			}
			
			// 원래 줄에서 세로 비교
			int resultC =0;
			for(int k=0; k<n; k++) {
				if(arr[x][y] != arr[x][k]) {
					resultC=0;
				}
				else {
					resultC++;
				}
				result = Math.max(resultC, result);
			}
			
			
			resultR = 0; 
			for(int k=0; k<n; k++) {
				if(arr[nx][ny] != arr[k][ny]) {
					resultR=0;
				}
				else {
					resultR++;
				}
				result = Math.max(resultR, result);
			}
			
			
			// 바꾼 줄에서 세로 비교
			resultC = 0;
			for(int k=0; k<n; k++) {
				if(arr[nx][ny] != arr[nx][k]) {
					resultC=0;
				}
				else {
					resultC++;
				}
				result = Math.max(resultC, result);
			}
			
			// 바꾼거 다시 되돌려놓기
			tmp = arr[x][y];
			arr[x][y] = arr[nx][ny];
			arr[nx][ny] = tmp;	
		}
	}
}