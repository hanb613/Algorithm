import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static long total, result;
    static Info[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Info[n];

        long x, y;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            arr[i] = new Info(x, y);
            total+=y; // 전체 인구 수
        }

        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            result+=arr[i].a;
            if((total+1)/2 <= result) { // 제일 먼저 전체 인구의 절반보다 크거나 같은 마을
                System.out.println(arr[i].x);
            	break;
            }
        }
    }

    private static class Info implements Comparable<Info> {
        long x, a;

        public Info(long x, long a){
            this.x=x;
            this.a=a;
        }

        @Override
        public int compareTo(Info o) {
            return (int)(this.x-o.x);
        }
    }
}
