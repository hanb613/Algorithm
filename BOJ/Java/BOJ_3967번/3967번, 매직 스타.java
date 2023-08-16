import java.util.*;
import java.io.*;

public class Main {

    static int CNT;
    static char[]  num;
    static char[][] arr;
    static boolean[] visited;

    // 각 라인에서 더해야 할 idx
    static int[][] sumArr = {{0, 2, 5, 7}, {1, 2, 3, 4}, {1, 5, 8, 11},
                            {0, 3, 6, 10}, {4, 6, 9, 11}, {7, 8, 9, 10}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new boolean[13];
        num = new char[12];
        arr = new char[5][9];

        int idx=0;
        for(int i=0; i<5; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0; j<9; j++){
                if(arr[i][j]=='x') idx++;
                if(arr[i][j]!='.' && arr[i][j]!='x'){ // A~L인 칸
                    num[idx++]=arr[i][j];
                    visited[arr[i][j]-64]=true;
                    CNT++;
                }
            }
        }

        Solution(0, CNT);

    }

    private static void Solution(int k, int cnt){
        if(cnt==12){
            // 각 라인의 합 구하기
            int sumCnt=0;
            for(int i=0; i<6; i++){
                int sum=0;
                for(int j=0; j<4; j++){
                    if(sum>26) return; // 26 넘으면 바로 return
                    sum+=(num[sumArr[i][j]]-64); //
                }
                if(sum==26) sumCnt++;
            }

            // 6라인 모두 합이 26일 때 출력 후 종료
            if(sumCnt==6){
                int idx=0;
                for(int i=0; i<5; i++){
                    for(int j=0; j<9; j++){
                        if(arr[i][j]!='.'){
                            System.out.print(num[idx++]);
                        } else System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            }

            return;
        }

        // 입력부터 이미 골라진 상태일 때
        if(num[k]!=0) Solution(k+1, cnt);
        else{
            for(int i=1; i<=12; i++){
                if(!visited[i]){
                    visited[i]=true;
                    num[k] = (char) (64+i);
                    Solution(k+1, cnt+1);
                    num[k] = 0;
                    visited[i]=false;
                }
            }
        }
    }
}
