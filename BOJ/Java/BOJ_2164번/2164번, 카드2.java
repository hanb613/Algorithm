import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int s, p, check;
	static String str;
	static int[] cnt, tmpCnt;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) {
        	q.offer(i); // 1~n까지 카드 넣기
        }
        
        while(true) {
        	if(q.size()==1) break; // 마지막으로 1장 남았으면 break
        	q.poll(); // 제일 위에 있는 카드 버리기
        	int next = q.poll(); // 다음 숫자카드 꺼내서
        	q.offer(next);  // 넣기
        }
        
        System.out.println(q.peek());
    }
}