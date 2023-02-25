import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static char[][] arr;
    static boolean[][] visit;
    static ArrayList<Character> retList;
    static int[] dx = {-1, 0, 1, 0}; // 상 하 좌 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[n][m];
        visit = new boolean[n][m];
        retList = new ArrayList<Character>();
        
        String str;
        for(int i=0; i<n; i++) {
            str=br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        retList.add(arr[0][0]);
        DFS(0, 0, 0);
        
        System.out.println(result);
    }
    
    private static void DFS(int x, int y, int cnt) {
    	result = Math.max(result, retList.size());
    		    	
    	for(int d=0; d<4; d++) {
    		int nx = x+dx[d];
    		int ny = y+dy[d];
    		if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
    		if(visit[nx][ny]) continue;
    		
    		if(!retList.contains(arr[nx][ny])) {
        			visit[nx][ny]=true;
        			retList.add(arr[nx][ny]);
        			DFS(nx, ny, cnt+1);
        			visit[nx][ny]=false;
        			retList.remove(retList.size()-1);
    		}
    	}
		return;

    }
}