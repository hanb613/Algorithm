import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int h, w, n;
    static Info dao;
    static Info[][] dir;
    static char[][] arr;
    static boolean[] check;
    static ArrayList<String> road;

    static int[] dx = {-1, 0, 1, 0}; // 상 좌 하 우
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new char[h][w];

        String str = "";
        for(int i=0; i<h; i++){
            str = br.readLine();
            for(int j=0; j<w; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j]=='D') dao = new Info(i, j);
            }
        }

        n = Integer.parseInt(br.readLine());

        check = new boolean[n];
        dir = new Info[n][2];
        road = new ArrayList<String>();
        
        for(int i=0; i<n; i++){
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<2; j++) {
            	str = st.nextToken();
    
            	if(str.equals("W")) dir[i][j] = new Info(0, str);
            	else if(str.equals("A")) dir[i][j] = new Info(1, str);
            	else if(str.equals("S")) dir[i][j] = new Info(2, str);
            	else if(str.equals("D")) dir[i][j] = new Info(3, str);
            }
        }
        
        Solution(dao.x, dao.y, 0);

        System.out.println("NO");
		
    }

    private static void Solution(int x, int y, int cnt) {   
    	
    	for(int i=cnt; i<n; i++) {
    		check[i]=false;
    		for(int j=0; j<2; j++) {
    			int nx = x+dx[dir[i][j].dir];
        		int ny = y+dy[dir[i][j].dir];
        		
        		if(nx<0 || ny<0 || nx>=h || ny>=w || arr[nx][ny]=='@') continue;

        		road.add(dir[i][j].dirC); // 경로 넣기
        		check[i] = true; // i번쨰 움직임
        		
        		if(arr[nx][ny]=='Z') { // 디지니 발견하면 바로 출력 후 종료
        			System.out.println("YES");
    				for(int k=0; k<road.size(); k++) {
    					System.out.print(road.get(k));
    				}
    				System.exit(0);
        		} else { // 다음꺼 탐색
            		Solution(nx, ny, i+1);
            		road.remove(road.size()-1);
            		check[i]=false;
        		}
    		}
    		
    		if(!check[i]) return; // i번쨰에 움직이지 못했으면
    	}
    }
    
    private static class Info{
        int x, y, dir;
        String dirC;

        public Info(int dir, String dirC){
        	this.dir = dir;
            this.dirC = dirC;
        }

        public Info(int x, int y){
        	this.x = x;
        	this.y = y;
        }
    }
}
