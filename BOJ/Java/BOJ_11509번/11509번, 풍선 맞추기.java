import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n, num, result;
    static int[] height;
    static int maxHeight=1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        height = new int[maxHeight+1];

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num = Integer.parseInt(st.nextToken());

            if(height[num+1]==0){
                result++;
                height[num]++;
            } else {
                height[num+1]--;
                height[num]++;
            }
        }

        System.out.println(result);
    }
}