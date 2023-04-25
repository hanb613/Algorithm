import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] happy, sad;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		happy = new int[n];
		sad = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			sad[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = solve(0, 100);
		
		System.out.println(result);
	}
	
	private static int solve(int k, int power) {
		if(k==n) return 0;
		
		int yes=0, no=0;
		
		// 현재 체력에서 인사를 할 수 있다면 ? 인사하기
		if(power - sad[k] > 0) {
			yes = solve(k+1, power - sad[k]) + happy[k];
		}
		
		// 인사 안하기
		no = solve(k+1, power);
		
		return Math.max(yes, no);
	}
}
