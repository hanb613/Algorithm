import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long min, max;
    static int[] arr, oper, cal;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        oper = new int[4];
        cal = new int[n-1];
        
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	oper[i] = Integer.parseInt(st.nextToken());
        }
        
        Solution(0);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void Solution(int cnt) {
        if (cnt == n-1) {
        	calcFunc();
            return;
        }

        for (int i=0; i<4; i++) {
            if (oper[i]!=0) {
                cal[cnt] = i;
                oper[i]--;
                Solution(cnt+1);
                oper[i]++;
            }
        }
    }

    private static void calcFunc() {

        Deque<Integer> nums = new LinkedList<>();
        Deque<Integer> opers = new LinkedList<>();
        nums.add(arr[0]);

        for (int i=0; i<n-1; i++) {
            switch (cal[i]) {
                case 0:  case 1:
                    nums.addLast(arr[i+1]);
                	opers.addLast(cal[i]);
                    break;
                case 2:
                	nums.addLast(nums.pollLast() * arr[i+1]);
                    break;
                case 3:
                	nums.addLast(nums.pollLast() / arr[i+1]);
                    break;
            }
        }

        int ret = nums.poll();
        
        while (!opers.isEmpty()) {
            int operator = opers.poll();
            int num = nums.poll();

            if(operator==0) ret += num;
            if(operator==1) ret -= num;
        }

        max = Math.max(ret, max);
        min = Math.min(ret, min);

    }
}