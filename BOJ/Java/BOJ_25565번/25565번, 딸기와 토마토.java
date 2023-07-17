import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, cnt, result;
    static boolean row, col;
    static int[][] arr, map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(arr[i][j]==1) {
        			row = col = false;
					
					// 가로
					if(n-i>=k) { // 연속으로 k개 심을 수 있으면
						for(int l=0; l<k; l++) {
							if(arr[i+l][j]==0) { // 연속으로 심을 수 없음
								row = true; break;
							}
						}
						if(!row) {
							cnt++; // 연속으로 k개 심을 수 있는 경우의 수 +1
							for(int l=0; l<k; l++) {
								map[i+l][j]++;
							}
						}
					}
					
					// 세로
					if(m-j>=k) { // 연속으로 k개 심을 수 있으면
						for(int l=0; l<k; l++) {
							if(arr[i][j+l]==0) { // 연속으로 심을 수 없음
								col = true; break;
							}
						}
						if(!col) {
							cnt++;
							for(int l=0; l<k; l++) {
								map[i][j+l]++;
							}
						}
					}
        		}
        	}
        }
        
        // 출력
        for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(map[i][j] == cnt) {
        			result++;
        			sb.append(i+1).append(" ").append(j+1).append("\n");        				
    			}
    		}
        }
        
    	System.out.println(result);
        System.out.println(sb.toString());
    }
}