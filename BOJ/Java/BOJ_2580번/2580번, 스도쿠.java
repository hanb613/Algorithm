import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static ArrayList<Info> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[9][9];
        list = new ArrayList<>();

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0) list.add(new Info(i, j));
            }
        }

        Solution(0);
    }

    private static void Solution(int k){
        if(k == list.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        for(int i=1; i<=9; i++){
            int nx = list.get(k).x;
            int ny = list.get(k).y;

            if(check(nx, ny, i)){
                arr[nx][ny] = i;
                Solution(k+1);
                arr[nx][ny]=0;
            }
        }

    }

    private static boolean check(int x, int y, int num){
        for(int i=0; i<9; i++){
            // 가로
            if(i!=x && arr[i][y]==num) return false;

            // 세로
            if(i!=y && arr[x][i]==num) return false;
        }

        // 3*3
        int nx = (x/3) * 3; // 3x3의 행의 첫 위치
        int ny = (y/3) * 3; // 3x3의 열의 첫 위치

        for(int i=nx; i<nx+3; i++){
            for(int j=ny; j<ny+3; j++){
                if((i!=x && j!=y) && arr[i][j]==num) return false;
            }
        }

        return true;
    }

    private static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}