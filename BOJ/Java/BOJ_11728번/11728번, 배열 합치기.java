import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            result.add(Integer.parseInt(A[i]));
        }
        for(int i = 0; i < m; i++){
            result.add(Integer.parseInt(B[i]));
        }

        Collections.sort(result);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            builder.append(result.get(i) + " ");
        }

        System.out.println(builder);
    }
}