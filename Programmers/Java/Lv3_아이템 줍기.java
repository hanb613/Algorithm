import java.util.*;

class Solution {
    
    static int answer;
    static int[][] arr;
    static boolean[][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        answer = Integer.MAX_VALUE;
        arr = new int[101][101];
        visited = new boolean[101][101];
        
        // 배열 초기화
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            // 테두리 : 1, 내부 : 2
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    if(arr[x][y]==2) continue; // 이미 채워진 내부일 때, 테두리 될 수 X
                    
                    if(x==x1 || x==x2 || y==y1 || y==y2) arr[x][y] = 1;
                    else arr[x][y] = 2;
                }
            }
        }
        
        BFS(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer/2;
    }
    
    private static void BFS(int cX, int cY, int iX, int iY){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(cX, cY));
        visited[cX][cY] = true;
              
        while(!q.isEmpty()) {
            Info p = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || ny<0 || nx>=101 || ny>=101) continue;
                if(visited[nx][ny] || arr[nx][ny] != 1) continue;
                
                arr[nx][ny] = arr[p.x][p.y]+1;
                    
                if(nx == iX && ny == iY) { // 아이템 위치에 도착했을 때        
                    answer = Math.min(answer, arr[nx][ny]);
                    continue;
                }
                
                visited[nx][ny] = true;
                q.add(new Info(nx, ny));
            }
        }
    }
    
    private static class Info{
        int x, y;
        
        public Info(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}