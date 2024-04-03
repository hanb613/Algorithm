import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		if(n<=10) {
			System.out.println(n);
		} else {
			for(int i=0; i<10; i++) {
				solve(i, 1);
			}
			if(n>=list.size()) {
				System.out.println(-1);
			} else {
				Collections.sort(list);
				System.out.println(list.get(n));
			}
		}

	}

	private static void solve(long k, int cnt) {
		if(cnt>10) return;
		
		list.add(k);
		for(int i=0; i<k%10; i++) { // 현재 수 보다 작은 수를 뒤에 추가
			solve((k*10)+i, cnt+1);
		}
		
	}
	
}