import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, total, twoCnt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total+=arr[i];
            twoCnt+=arr[i]/2; // 2를 사용한 횟수
        }

        // 총 나무 높이가 3의 배수가 X => NO
        // 2를 사용한 횟수가 총 일수보다 작으면 => NO
        if(total%3!=0 || twoCnt<total/3) System.out.println("NO");
        else System.out.println("YES");
    }
}