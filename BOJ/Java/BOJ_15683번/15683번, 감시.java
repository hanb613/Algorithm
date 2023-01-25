import java.io.*;
import java.util.*;

public class Main {
	static int n, m, total, result, cnt;
    static CCTV[] cctv;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[][] arr;
    static int[][][] dir = {
            {{0}}, // X
            {{1}, {2}, {3}, {0}}, // 1번
            {{0, 2}, {1, 3}}, // 2번 
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번
            {{0, 1, 2, 3}}, // 5번
    };
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        total = n * m;
        result = Integer.MAX_VALUE;
        
        arr = new int[n][m];
        cctv = new CCTV[8];
        
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctv[cnt++] = new CCTV(i, j, arr[i][j]);
                } 
                else if(arr[i][j] == 6) total--;
            }
        }
        
        Solution(arr, 0, total - cnt);
        
        System.out.println(result);
    }
 
    public static void Solution(int[][] map, int idx, int blank) {
        
    	if(idx == cnt) { // 모든 cctv 확인
            result = Math.min(result, blank);
            return;
        }
        
        int[][] newArr = new int[n][m];

        copy(newArr, map);
        
        CCTV cc = cctv[idx];
        
        for (int i = 0; i < dir[cc.dir].length; i++) { // CCTV 90도씩 회전
            int check = 0;

            for (int j = 0; j < dir[cc.dir][i].length; j++) {
                int d = dir[cc.dir][i][j];
                check += countArr(cc.x, cc.y, d, newArr);
            }
            
            Solution(newArr, idx + 1, blank - check);
            
            copy(newArr, map);
        }
        
    }
    
	public static void copy(int[][] A, int[][] B) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = B[i][j];
            }
        }
        
    }
	
    public static int countArr(int x, int y, int d, int[][] map) {
        
        int cnt = 0;
        
        while(true) {
            x += dx[d];
            y += dy[d];
            
            
            if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 6) return cnt;
            
            if(map[x][y]==0) {
                map[x][y] = 7;
                cnt++;            	
            }
        }
        
    }
 
    static class CCTV {
        int x, y, dir;
 
        public CCTV(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        
    }
}
