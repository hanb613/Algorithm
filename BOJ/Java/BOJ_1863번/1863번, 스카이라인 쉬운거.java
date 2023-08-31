import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n, result;
	static int[] arr;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[50001];
		stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = b; // 높이 저장 (y)
		}
		
		for(int i=0; i<=n; i++) {
			while(!stack.isEmpty()) {
				if(stack.peek() > arr[i]) { // 높이가 낮아짐 => 빌딩 개수 +1
					stack.pop();
					result++;					
				} else break; // 높거나 같음
			}
			
			if(!stack.isEmpty() && stack.peek() == arr[i]) continue; // 같은 빌딩
			
			stack.push(arr[i]);
		}
		
		System.out.print(result);
	}
}