import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int result;
    static boolean chk;
    static boolean[][] visited;
    static char[][] arr;
	static ArrayList<Info> list;
	
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new char[12][6];
        list = new ArrayList<Info>();
        
        String str="";
        for(int i=0; i<12; i++){
            str = br.readLine();
            for(int j=0; j<6; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        
        while(true) {
            chk = false;

    		visited = new boolean[12][6];
            for(int k=0; k<12; k++) {
            	for(int i=0; i<6; i++) {
            		if(arr[k][i]!='.') {
                        list.clear(); // 터트릴 뿌요 리스트 초기화
                		
                		broke(k, i); // 터트릴 뿌요 확인
                		
                		// 같은 색 뿌요가 4개 이상이면 없어짐
                		if(list.size()>=4) {
                			for(int j=0; j<list.size(); j++) {
                				Info info = list.get(j);
                				arr[info.x][info.y] = '.'; // 없앰 				
                			}
                			chk=true;
                		}
            		}
            	}
            	
            }
        	
        	if(!chk) break; // 연쇄 X
        	
        	// 아래로 떨어뜨리기
        	for(int i=0; i<6; i++) {
        		for(int j=11; j>0; j--) {
        			if(arr[j][i]=='.') {
        				for(int k=j-1; k>=0; k--) {
        					if(arr[k][i]!='.') {
        						arr[j][i] = arr[k][i];
        						arr[k][i] = '.';
        						break;
        					}
        				}
        			}
        		}
        	}
        	
        	result++; // 연쇄 +1회
        }
        
        System.out.println(result);

    }

    
    private static void broke(int x, int y) {
    	Queue<Info> q = new LinkedList<Info>();
		visited[x][y]=true;
		q.add(new Info(x, y, arr[x][y]));
		list.add(new Info(x, y, arr[x][y]));
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=12|| ny>=6) continue;
				if(visited[nx][ny] || p.num != arr[nx][ny]) continue;
				
				visited[nx][ny]=true;
				list.add(new Info(nx, ny, arr[nx][ny])); // 터트릴 뿌요 정보 넣기
				q.offer(new Info(nx, ny, arr[nx][ny]));
			}
		}
		
        return;
    	
	}
    
	private static class Info{
		int x, y;
		char num;
		
		public Info(int x, int y, char num) {
			this.x=x;
			this.y=y;
			this.num=num;
		}
	}
}