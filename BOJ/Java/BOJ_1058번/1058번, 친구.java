import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, result;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		n = Integer.parseInt(br.readLine());
		arr=new int[n][n];
		
		String str="";
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				if(str.charAt(j)=='Y') {
					arr[i][j]=1;
				} else if(i!=j){
					arr[i][j]=987654321; 
				}
			}
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i==j || j==k || k==i) continue;
					else if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			int tmp=0;
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				else if(arr[i][j]<=2) tmp++;
			}
			result=Math.max(result, tmp);
		}
		
		System.out.println(result);
	}
}