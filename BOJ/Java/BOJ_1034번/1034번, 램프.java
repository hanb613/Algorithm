import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, result;
    static char[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n];

        String str = "";
        for(int i=0; i<n; i++) {
            str = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int zeroCnt=0;
            for(int j=0; j<m; j++){
                if(arr[i][j]=='0') zeroCnt++;
            }

            if(zeroCnt<=k){ // 한 행에 있는 0이 k보다 작아야됨
                int zeroMod = zeroCnt%2;
                int kMod = k%2;
                int cnt=1;

                if(zeroMod == kMod){ // [k 짝수 == zero 짝수] || [k 홀수 == zero 홀수]
                    visited[i]= true; // 행 방문체크

                    for(int j=i+1; j<n; j++){ // i 다음 행
                        if(!visited[j]){ // 방문 안한 행 
                            boolean check=true;
                            for(int l=0; l<m; l++){
                                if(arr[i][l] != arr[j][l]){
                                    check=false; break;
                                }
                            }
                            if(check) { // 지금 행이랑 똑같음
                                visited[j]= true;
                                cnt++;
                            }
                        }
                    }

                    result = Math.max(result, cnt);
                }
            }
        }

        System.out.println(result);
    }
}