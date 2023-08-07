import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int left=0, right=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right+=arr[i];
        }

        while(left<=right){
            int mid = (left+right)/2;

            // 블루레이의 길이에 따라 만들어지는 강의 수
            int sum=0, cnt=0;
            for(int i=0; i<n; i++){
                if(sum+arr[i]<=mid) sum+=arr[i];
                else {
                    cnt++; sum=arr[i];
                }
            }

            if(cnt>=m){
                left=mid+1;
            } else{
                result=mid;
                right=mid-1;
            }
        }

        System.out.println(result);
    }
}