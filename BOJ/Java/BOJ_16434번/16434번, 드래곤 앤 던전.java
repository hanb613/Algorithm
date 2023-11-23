import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long attack, result=Long.MAX_VALUE;
    static Info[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        attack = Integer.parseInt(st.nextToken());

        arr = new Info[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        long left=1, right=Long.MAX_VALUE-1;
		
        while(left<=right){
            long mid = (left+right)/2;

            if(Solution(attack, mid)){
                result = Math.min(result, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(result);
    }

    private static boolean Solution(long att, long maxHP){
        long HP=maxHP;

        for(int i=0; i<n; i++){
            if(arr[i].t==1){
                long count = arr[i].h / att;
                if(arr[i].h % att==0) count--; // 한대 덜 맞고 몬스터 kill 가능

                HP-=(arr[i].a * count);
                if(HP<=0) return false;

            } else{
                att+=arr[i].a;
                if(HP+arr[i].h>=maxHP) HP=maxHP;
                else HP+=arr[i].h;
            }
        }

        return true;
    }

    private static class Info{
        int t, a, h;

        public Info(int t, int a, int h){
            this.t=t;
            this.a=a;
            this.h=h;
        }
    }
}
