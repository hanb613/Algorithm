import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Queue<Long> q;
    static long num, maxNum, result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        q = new LinkedList<>();

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            num = Long.parseLong(br.readLine());
            maxNum = Math.max(maxNum, num); // 큰 값 갱신

            if(q.isEmpty()) q.offer(num);
            else{
                if(q.peek() > num){ // top > 새로 들어온 수
                    q.poll();
                    q.offer(num);
                } else if(q.peek() < num){ // top < 새로 들어온 수
                    result+=(num-q.poll()); // 차이만큼 +
                    q.offer(num);
                }
            }
        }

        while(!q.isEmpty()){ // q 안 비어 있으면 ? max랑 차이 값 더해주기
            result+=(maxNum-q.poll());
        }

        System.out.println(result);

    }
}
