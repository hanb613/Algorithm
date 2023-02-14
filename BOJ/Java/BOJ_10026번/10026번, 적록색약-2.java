import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, resultA, resultB;
    static char[][] arr;
    static boolean[][] visitA, visitB;
    static int[] dx = {-1, 0, 1, 0}; // 상 하 좌 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new char[n][n];
        visitA = new boolean[n][n];
        visitB = new boolean[n][n];
        
        String str;
        for(int i=0; i<n; i++) {
            str=br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visitA[i][j]) { // 일반 사람
                	BFS(0, i, j, arr[i][j]);
                	resultA++;
                }
                if(!visitB[i][j]) { // 적록색약인 사람
                	BFS(1, i, j, arr[i][j]);
                	resultB++;
                }
            }
        }
        
        System.out.println(resultA + " " + resultB);
    }

    private static void BFS(int type, int x, int y, char c) { // 0: 일반 사람, 1: 적록색약인 사람
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(x, y));
        if(type==0) visitA[x][y] = true;
        else visitB[x][y]=true;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                
                if(type==1) { // 적록색약
                	if(visitB[nx][ny]) continue;
                	
                	// R랑 G 똑같이 만들기
                	if(c=='R' && arr[nx][ny]=='G') c='G';
                    else if(c=='G' && arr[nx][ny]=='R') c='R';
                }
                else { // 일반인
                	if(visitA[nx][ny]) continue;
                }
                
                if(arr[nx][ny]==c) {
                	if(type==0) visitA[nx][ny]=true;
                    else visitB[nx][ny]=true;
                    
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    
    private static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}