import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static char[][] arr;
    static int[][] visited;

    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new int[n][n];

        String str="";
        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<n; j++){
                visited[i][j] = -1; // 아무 색 없음
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == -1 && arr[i][j] == 'X'){ // 방문 하지 X + 'X'인 위치
                    Solution(i, j, 0);
                }
            }
        }

        System.out.println(result);
    }

    private static void Solution(int x, int y, int color) {
        visited[x][y] = color;
        result = Math.max(result, 1);

        for(int i=0; i<6; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

            if (arr[nx][ny] == 'X') {
                if(visited[nx][ny] == -1){
                    Solution(nx, ny, 1 - color); // 0, 1, 0, 1 반복
                    result = Math.max(result, 2);
                }
                else if (visited[nx][ny] == color) { // 주변에 0 1 색칠해있음 => 다른색깔
                    result = 3; return;
                }
            }
        }
    }
}