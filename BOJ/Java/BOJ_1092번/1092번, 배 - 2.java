import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n, m, result;
    static ArrayList<Integer> arr, weight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());
        weight  = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            weight.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(weight, Collections.reverseOrder());

        if(arr.get(0)<weight.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }

        while(weight.size()!=0){
            for(int i=0; i<n; i++){
                for(int j=0; j<weight.size(); j++){
                    if(weight.get(j)<=arr.get(i)){
                        weight.remove(j);
                        break;
                    }
                }
            }
            result++;
        }

        System.out.println(result);
    }
}