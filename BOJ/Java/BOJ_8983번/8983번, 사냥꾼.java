import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n, l, result;
    static int[] xList;
    static Info[] animal;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        animal = new Info[n];        
        xList = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
        	xList[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(xList);
        
        int x, y;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	animal[i] = new Info(x, y);
        }
                
        for(int i=0; i<n; i++) {
        	if(animal[i].y>l) continue; // y좌표가 l보다 커서 어차피 안됨 
        	int left=0, right=m-1, mid=0;
    		
        	while(left<=right) {
        		mid = (left+right)/2;
        		
        		int dist = Math.abs(xList[mid]-animal[i].x)+animal[i].y; // 해당 동물에서 사대까지 거리
        		
        		if(dist<=l) { // 사정거리 안에 있음
        			result++; break;
        		} else { // 사정거리 밖에 있음
        			if(animal[i].x>=xList[mid]) { // 동물 좌표가 사대보다 오른쪽에 있을때
        				left = mid+1;
        			} else { // 왼쪽에 있을 때
        				right = mid-1;
        			}
        		}
        	}
        }
        
        System.out.println(result);
    }
    
    private static class Info {
    	int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
}