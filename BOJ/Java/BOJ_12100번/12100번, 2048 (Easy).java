import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int n, result;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0: 상, 1: 우, 2: 하, 3: 좌
		Solution(0, arr);
		
		System.out.println(result);
	}
	
	public static void move(int dir, int[][] arr) {
		if(dir==0) { // 상
			for(int y=0; y<n; y++) {
				int num=0, idx=0;
				for(int x=0; x<n; x++) {
					if(arr[x][y]!=0){
						if(num != arr[x][y]) {
							num=arr[x][y]; idx=x;
						}
						else {
							arr[x][y]*=2;
							arr[idx][y]=0;
							num=0; idx=0; // 동시에 두번 합쳐지기 X
						}
					}
				}
				
				idx=0;
				for(int z=0; z<n; z++) {
					if(arr[z][y]!=0) {
						result=Math.max(result, arr[z][y]);
						
						int temp=arr[z][y];
						arr[z][y]=0;
						arr[idx][y]=temp;
						idx++;
					}
				}
			}
		}
		
		else if(dir==1) { // 우
			for(int x=0; x<n; x++) {
				int num=0, idx=0;
				for(int y=n-1; y>=0; y--)
					if(arr[x][y]!=0){
						if(num!=arr[x][y]) {
							num=arr[x][y]; idx=y;
						}
						else {
							arr[x][y]*=2;
							arr[x][idx]=0;
														
							num=0; idx=0;	
						}
				}
				
				idx=n-1;
				for(int z=n-1; z>=0; z--) {
					if(arr[x][z]!=0) {
						result=Math.max(result, arr[x][z]);
						
						int temp=arr[x][z];
						arr[x][z]=0;
						arr[x][idx]=temp;
						idx--;
					}
				}
			}
		
		}
		
		else if(dir==2) { // 하
			for(int y=0; y<n; y++) {
				int num=0, idx=0;
				for(int x=n-1; x>=0; x--) {
					if(arr[x][y]!=0){
						if(num!=arr[x][y]) {
							num=arr[x][y]; idx=x;
						}
						else {
							arr[x][y]*=2;
							arr[idx][y]=0;							
							num=0; idx=0;
						}
					}
				}
				
				idx=n-1;
				for(int z=n-1; z>=0; z--) {
					if(arr[z][y]!=0) {
						result=Math.max(result, arr[z][y]);
						
						int temp=arr[z][y];
						arr[z][y]=0;
						arr[idx][y]=temp;
						idx--;
					}
				}
			}
		}
		
		else if(dir==3) { // 좌
			for(int x=0; x<n; x++) {
				int num=0, idx=0;
				for(int y=0; y<n; y++) {
					if(arr[x][y]!=0){
						if(num!=arr[x][y]) {
							num=arr[x][y]; idx=y;
						}
						else {
							arr[x][y]*=2;
							arr[x][idx]=0;
							num=0; idx=0;
						}
					}
				}
			
				idx=0;
				for(int z=0; z<n; z++) {
					if(arr[x][z]!=0) {
						result=Math.max(result, arr[x][z]);
						
						int temp=arr[x][z];
						arr[x][z]=0;
						arr[x][idx]=temp;
						idx++;
					}
				}
			}
		}
	}
	
	public static void copyArr(int[][] A, int[][] B) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j]=B[i][j];
			}
		}
	}
	
	public static void Solution(int k, int[][] arr) {
		if(k==5) {
			return;
		}
		
		int[][] newArr = new int[n][n];
		
		for(int i=0; i<4; i++) {	
			copyArr(newArr, arr);
			move(i, newArr);
			Solution(k+1, newArr);
		}
	}
}
