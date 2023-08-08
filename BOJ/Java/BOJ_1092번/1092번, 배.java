import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n, m, result;
    static int[] arr, weight;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        weight = new int[m];
        visited = new boolean[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        if(arr[n-1]<weight[m-1]) {
            System.out.println(-1);
        } else{
            int cnt=0;
            while(cnt!=m){
                int idx=m-1;
                for(int i=n-1; i>=0; i--){
                    while(idx>=0){
                        if(weight[idx]<=arr[i] && !visited[idx]){
                            cnt++; visited[idx]=true;
                            idx--;
                            break;
                        } idx--;
                    }
                }
                result++;
            }

            System.out.println(result);
        }
    }
}