import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, result=Integer.MAX_VALUE;
    static int[][] arr;
    static int[] numArr;
    static boolean[] visit;
    static Pair[] oper;
    static int x, y, r;
    static List<Integer> list;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        oper = new Pair[k];
        visit = new boolean[k];
        numArr = new int[k];
	    arr = new int[n+1][m+1];
	    
	    for(int i=1; i<=n; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j=1; j<=m; j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0; i<k; i++) {
	        st = new StringTokenizer(br.readLine());
	        x = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        r = Integer.parseInt(st.nextToken()); 
	        oper[i] = new Pair(x,y,r);
	    }
	    
	    Solution(0);
	    
	    System.out.println(result);
	}
    
    public static void copyArr(int[][] A, int[][] B) {
    	for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				A[i][j] = B[i][j];
			}
		}
    }

    public static void Solution(int idx) {
    	if(idx == k) {
        	int[][] newArr = new int[n+1][m+1];
        	
        	copyArr(newArr, arr); // 원래 배열 -> temp     		
        	
        	for(int t=0; t<k; t++) {
        		int tc = numArr[t];
        		Rotation(oper[tc].x, oper[tc].y, oper[tc].s);
        		
        	}
        	
        	// 각 행에 있는 모든 수의 합 중 최솟값 찾기
        	for(int i=1; i<=n; i++) {
    			int ret1=0;
    			for(int j=1; j<=m; j++) {
    				ret1+=arr[i][j];
    			}
    			result = Math.min(ret1, result);
			}
        	
        	copyArr(arr, newArr);
        	
            return;
    	}
    	
    	for(int i=0; i<k; i++) {
    		if(!visit[i]) {
    			visit[i]=true;
                numArr[idx] = i;
                Solution(idx+1);
                visit[i]=false;
    		}
    	}
    }
    
	public static void Rotation(int x, int y, int r) {
		
	    int nx=x-r; // 1
	    int nx2=x+r; // 5
	    int ny=y+r; // 6
	    int ny2=y-r; // 2
	    
	    if(nx == nx2 && ny == ny2)return;
	    
	    for(int i=ny2; i<=ny; i++) {
	    	list.add(arr[nx][i]);
	    }
	    for(int i=nx+1; i<=nx2; i++) {
	    	list.add(arr[i][ny]);
	    }
	    for(int i=ny-1; i>=ny2; i--) {
	    	list.add(arr[nx2][i]);
	    }
	    for(int i=nx2-1; i>nx; i--) {
	    	list.add(arr[i][ny2]);
	    }
	    
	    int idx = 0;
	    for(int i=ny2+1; i<=ny; i++) {
	        arr[nx][i] = list.get(idx++);
	    }
	    for(int i=nx+1; i<=nx2; i++) {
	    	arr[i][ny] = list.get(idx++);
	    }
	    for(int i=ny-1; i>=ny2; i--) {
	    	arr[nx2][i] = list.get(idx++);
	    }
	    for(int i=nx2-1; i>=nx; i--) {
	    	arr[i][ny2] = list.get(idx++);
	    }
	    
	    list.clear();
	    
	    Rotation(x, y, r-1);
	}
	
	public static class Pair{
		int x, y, s;
		Pair(int x, int y, int s){
			this.x=x;
			this.y=y;
			this.s=s;
		}
	}
}