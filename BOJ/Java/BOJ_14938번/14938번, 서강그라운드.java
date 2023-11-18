import java.io.*;
import java.util.*;

public class Main {
    
	static int n, m, r, result; 
	static int[][] arr;
	static int[] item;
	
	public static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        item = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                arr[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
        	item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<r; i++) {
        	st = new StringTokenizer(br.readLine());
        	
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
		
            arr[a][b] = w; // 양방향
            arr[b][a] = w;
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (arr[i][j] > arr[i][k]+arr[k][j]) {
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }

        for (int i=1; i<=n; i++) {
        	int sum=0;
            for (int j=1; j<=n; j++) {
                if(arr[i][j]<=m){
                	sum+=item[j];
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}