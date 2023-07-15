import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k, m, minNum, maxNum, result;
    static boolean[] arr, visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new boolean[(int)Math.pow(10, k)+1];
        visited = new boolean[10];
        
        prime();
        select(0, 0);
        
        System.out.println(result);
    }
    
    private static void select(int cnt, int num) {
    	if(cnt==k) {
    		boolean check=false;
    		boolean check2=false;
    		
    		// 1번 만족
            for(int j=2; j<=num; j++) {
            	if(j!=num-j && !arr[j] && !arr[num-j]) {
            		check=true; break;
            	}
            }
            
            // 2번 만족
            int num2=num;
            while(num2%m==0) {
            	num2/=m;
            }
            
            for(int j=2; j<=num2; j++) {
            	if(!arr[j] && (num2%j==0 && !arr[num2/j])) {
            		check2=true; break;
            	}
            }
            
            if(check && check2) result++;
            
    		return;
    	}
    	
    	for(int i=0; i<10; i++) {
    		if (cnt==k-1 && i==0) continue; // 맨 앞에 0 X
    		
    		if(!visited[i]) {
    			visited[i]=true;
    			select(cnt+1, num + i * (int)Math.pow(10, cnt));
    			visited[i]=false;
    		}
    	}
    }

    // 에라토스테네스의 체
    private static void prime() {
    	int n = (int)Math.pow(10, k);
    	
    	arr[0] = arr[1] = true; // 0과 1은 소수 X
    	
    	for(int i=2; i<=Math.sqrt(n); i++) {
    		if(!arr[i]) {
    			for(int j=i*i; j<=n; j+=i) {
    				arr[j] = true;
    			}
    		}
    	}
    }
}