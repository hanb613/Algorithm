import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, result;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break; // 입력이 0 0이면 종료

            result=0;
            arr = new int[w][h];
            visit = new boolean[w][h];

            for(int i=0; i<w; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<h; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<w; i++) {
                for(int j=0; j<h; j++) {
                    if(!visit[i][j] && BFS(i, j)) result++;
                }
            }

            System.out.println(result);
        }
    }

    private static boolean BFS(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();

        int cnt=0;
        q.add(new Pair(x, y));
        visit[x][y] = true;
        if(arr[x][y]==1) cnt++;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i=0; i<8; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || ny<0 || nx>=w || ny>=h || visit[nx][ny]) continue;
                if(arr[nx][ny]==1) {
                    visit[nx][ny]=true;
                    q.add(new Pair(nx, ny));
                    cnt++;
                }
            }
        }

        if(cnt!=0) return true;
        else return false;
    }

    private static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}