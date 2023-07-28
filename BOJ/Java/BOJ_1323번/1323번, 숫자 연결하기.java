import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int n, k, num, result;
	static boolean check;
	static boolean[] visitied;
	static long cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visitied = new boolean[100001];
        result=1;
        
        cnt = (long)Math.pow(10, (n+"").length());
        
        num = n%k;
        while(num!=0) { // 나누어지지 X
        	long ret = (num*cnt)+n; // 숫자 하나 이어붙이기 

        	num=(int)(ret%k); // k로 나눈 나머지
            if (visitied[num]) { // 이전에 나왔던거 => 결과 안나옴
                check=true; break;
            }
            visitied[num]=true;
            result++;
        }

        if (!check) System.out.println(result);
	    else System.out.println(-1);
    }
}
