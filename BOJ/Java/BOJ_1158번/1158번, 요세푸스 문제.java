import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, result;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(q.size()!=1) {
            for (int i=0; i<k-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()+", ");
        }
        
        sb.append(q.poll()+">");
        System.out.println(sb.toString());
	}
}