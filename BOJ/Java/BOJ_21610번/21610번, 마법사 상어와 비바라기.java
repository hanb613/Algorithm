import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] arr;
    static boolean[][] visit;
    static List<Pair> list;
    
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        list = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        /* 초기 구름 위치 */
        list.add(new Pair(n-2, 0));
        list.add(new Pair(n-2, 1));
        list.add(new Pair(n-1, 0));
        list.add(new Pair(n-1, 1));
        
        int d, s;
        for (int i=0; i<m; i++) {
            visit = new boolean[n][n];
            
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            move(d, s);
            magic();
            newClouds();
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result += arr[i][j];
            }
        }
        
        System.out.println(result);
    }

    private static void move(int d, int s) {
        for (int i=0; i<list.size(); i++) {
            list.get(i).x = (n + list.get(i).x + dx[d-1]*s % n) % n; // d 방향으로 s칸 이동
            list.get(i).y = (n + list.get(i).y + dy[d-1]*s % n) % n;
            visit[list.get(i).x][list.get(i).y] = true; // 구름이 있는 칸 체크
            arr[list.get(i).x][list.get(i).y]++; // 물의 양 1 증가
        }
    }
    
    private static void magic() {
        for (int i=0; i<list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            int cnt=0; // 물이 있는 바구니 수
            for (int d=1; d<8; d+=2) { // 대각선 방향으로 체크
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                
                if(arr[nx][ny]>0) cnt++; // 물 있으면 cnt++
            }
            arr[x][y]+=cnt;
        }
    }

    private static void newClouds() {
    	list.clear(); // 구름 사라짐
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Pair p = new Pair(i, j);
                if(!visit[i][j] && arr[i][j] >= 2) { // 물이 있었던 칸이 아니고, 물의 양이 2이상인 칸
                    list.add(p); 
                    arr[i][j] -= 2; // 물의 양 2 줄어듦
                }
            }
        }
    }
    
    private static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
