import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m, k, cnt;
	static int arr[][];
	static List<Integer> result;
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        result = new ArrayList<Integer>();
        arr = new int[m][n];
        
        int x1, y1, x2, y2;
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	x1=Integer.parseInt(st.nextToken());
        	y1=Integer.parseInt(st.nextToken());
        	x2=Integer.parseInt(st.nextToken());
        	y2=Integer.parseInt(st.nextToken());
        	
        	// 해당 영역 1로 만들기
        	for(int y=y1; y<y2; y++) {
        		for(int x=x1; x<x2; x++) {
        			arr[y][x]=1;
        		}
        	}
        }
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j]==0) { // 0이면 주변 영역 탐색
        			cnt=0;
        			DFS(i, j);
        			result.add(cnt);
        		}
        	}
        }
        
        // 영역의 넓이를 오름차순으로 정렬
        Collections.sort(result);
        
        System.out.println(result.size());
        for(int r : result) {
            System.out.print(r + " ");
        }
    }
    
    private static void DFS(int x, int y) {
    	arr[x][y]=1; // 방문한 영역 1로 만들기
    	cnt++;
    	
    	for(int i=0; i<4; i++) {
    		int nx=x+dx[i];
    		int ny=y+dy[i];
    		
    		if(nx<0 || ny<0 || nx>=m || ny>=n || arr[nx][ny]==1) continue;
    		DFS(nx, ny);
    	}
    }
}