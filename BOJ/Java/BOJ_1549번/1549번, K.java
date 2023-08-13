import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long resultK, result;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        result = Long.MAX_VALUE;

        long num=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            num = Long.parseLong(st.nextToken());
            arr[i] = arr[i-1] + num;
        }

        for(int k=1; k<=n-1; k++){
            for(int i=k; i<=n; i++){
                long sum=0;
                for(int j=k+i; j<=n; j++){
                    sum = Math.abs((arr[i]-arr[i-k]) - (arr[j]-arr[j-k]));
                    if(sum<=result){
                        resultK = k;
                        result = sum;
                    }
                }
            }
        }

        System.out.println(resultK);
        System.out.println(result);
    }
}